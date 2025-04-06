resource "aws_ecs_cluster" "auris_loading_cluster" {
  name = "auris-loading-cluster"

  setting {
    name  = "containerInsights"
    value = "enabled"
  }

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_iam_role" "ecs_instance_role" {
  name = "auris-ecs-instance-role"
  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Principal = {
          Service = "ec2.amazonaws.com"
        }
      }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "ecs_instance_role_attachment" {
  role       = aws_iam_role.ecs_instance_role.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AmazonEC2ContainerServiceforEC2Role"
}

resource "aws_iam_instance_profile" "ecs_instance_profile" {
  name = "auris-ecs-instance-profile"
  role = aws_iam_role.ecs_instance_role.name
}

resource "aws_launch_template" "ecs_launch_template" {
  name_prefix   = "auris-ecs-"
  image_id      = "ami-08ac61e31ce627a8f"
  instance_type = "t2.micro"

  iam_instance_profile {
    name = aws_iam_instance_profile.ecs_instance_profile.name
  }

  vpc_security_group_ids = [aws_security_group.ecs_security_group.id]

  user_data = base64encode(<<-EOF
    #!/bin/bash
    echo ECS_CLUSTER=${aws_ecs_cluster.auris_loading_cluster.name} >> /etc/ecs/ecs.config
  EOF
  )

  tag_specifications {
    resource_type = "instance"
    tags = {
      Name        = "auris-ecs-instance"
      Environment = "production"
      ManagedBy   = "terraform"
      Component   = "auris-loading"
    }
  }
}

resource "aws_autoscaling_group" "ecs_asg" {
  name                = "auris-ecs-asg"
  vpc_zone_identifier = [aws_subnet.auris_loading_public_subnet_1.id, aws_subnet.auris_loading_public_subnet_2.id]
  min_size            = 1
  max_size            = 2
  desired_capacity    = 1

  launch_template {
    id      = aws_launch_template.ecs_launch_template.id
    version = "$Latest"
  }

  tag {
    key                 = "AmazonECSManaged"
    value               = true
    propagate_at_launch = true
  }
}

resource "aws_ecs_capacity_provider" "ec2" {
  name = "auris-ec2-capacity-provider"

  auto_scaling_group_provider {
    auto_scaling_group_arn         = aws_autoscaling_group.ecs_asg.arn
    managed_termination_protection = "DISABLED"

    managed_scaling {
      maximum_scaling_step_size = 1
      minimum_scaling_step_size = 1
      status                    = "ENABLED"
      target_capacity           = 100
      instance_warmup_period    = 120
    }
  }
}

resource "aws_ecs_cluster_capacity_providers" "auris_cluster_capacity_providers" {
  cluster_name = aws_ecs_cluster.auris_loading_cluster.name

  capacity_providers = [aws_ecs_capacity_provider.ec2.name]

  default_capacity_provider_strategy {
    capacity_provider = aws_ecs_capacity_provider.ec2.name
    weight            = 100
    base              = 1
  }
}

resource "aws_iam_role" "auris_ecs_task_execution_role" {
  name = "auris-ecs-task-execution-role"
  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Principal = {
          Service = "ecs-tasks.amazonaws.com"
        }
      }
    ]
  })
}

resource "aws_iam_policy" "ecr_pull_cloudwatch_logs_policy" {
  name        = "auris-ecr-pull-cloudwatch-logs-policy"
  description = "Policy for ECR pull and CloudWatch logs access"

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect = "Allow",
        Action = [
          "ecr:GetAuthorizationToken"
        ],
        Resource = "*"
      },
      {
        Effect = "Allow",
        Action = [
          "ecr:GetDownloadUrlForLayer",
          "ecr:BatchGetImage",
          "ecr:BatchCheckLayerAvailability"
        ],
        Resource = "${data.terraform_remote_state.foundation.outputs.ecr_repository_arn}"
      },
      {
        Effect = "Allow",
        Action = [
          "logs:CreateLogStream",
          "logs:PutLogEvents",
          "logs:CreateLogGroup"
        ],
        Resource = "*"
      }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "ecr_pull_cloudwatch_logs_attachment" {
  role       = aws_iam_role.auris_ecs_task_execution_role.name
  policy_arn = aws_iam_policy.ecr_pull_cloudwatch_logs_policy.arn
}

# Task role for the ECS tasks (runtime permissions)
resource "aws_iam_role" "auris_ecs_task_role" {
  name = "auris-ecs-task-role"
  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Principal = {
          Service = "ecs-tasks.amazonaws.com"
        }
      }
    ]
  })
}

# Attach the S3 presigned URL policy to the task role instead of execution role
# resource "aws_iam_role_policy_attachment" "ecs_s3_policy_attachment" {
#   role       = aws_iam_role.auris_ecs_task_role.name
#   policy_arn = aws_iam_policy.s3_presigned_url_policy.arn
# }

resource "random_string" "auris_version_hash" {
  length  = 16
  special = false
  upper   = false
}

resource "aws_cloudwatch_log_group" "auris_ecs_log_group" {
  name              = "/ecs/auris-loading"
  retention_in_days = 14
  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_ecs_task_definition" "auris_ecs_task" {
  family                   = "auris-loading"
  network_mode             = "bridge"
  requires_compatibilities = ["EC2"]
  cpu                      = 800
  memory                   = 800
  execution_role_arn       = aws_iam_role.auris_ecs_task_execution_role.arn
  task_role_arn            = aws_iam_role.auris_ecs_task_role.arn
  container_definitions = jsonencode([
    {
      name      = "auris-loading"
      image     = "${data.terraform_remote_state.foundation.outputs.ecr_repository_url}:${var.app_image_tag}"
      cpu       = 800
      memory    = 800
      essential = true
      portMappings = [
        {
          containerPort = 8080
          hostPort      = 8080
        }
      ]
      healthCheck = {
        command = ["CMD-SHELL", "curl -f http://localhost:8080/actuator/health || exit 1"]
      }
      environment = [
        {
          name  = "APP_IMAGE_TAG"
          value = var.app_image_tag
        },
        {
          name  = "APP_VERSION_HASH"
          value = random_string.auris_version_hash.result
        },
        {
          name  = "DB_HOST"
          value = aws_db_instance.auris_loading_db.address
        },
        {
          name  = "DB_PORT"
          value = tostring(aws_db_instance.auris_loading_db.port)
        },
        {
          name  = "DB_NAME"
          value = aws_db_instance.auris_loading_db.db_name
        },
        {
          name  = "DB_USER"
          value = aws_db_instance.auris_loading_db.username
        },
        {
          name  = "DB_PASSWORD"
          value = data.terraform_remote_state.foundation.outputs.auris_loading_db_password
        }
      ]
      logConfiguration = {
        logDriver = "awslogs"
        options = {
          "awslogs-group"         = aws_cloudwatch_log_group.auris_ecs_log_group.name
          "awslogs-region"        = "us-west-1"
          "awslogs-stream-prefix" = "ecs"
          "awslogs-create-group"  = "true"
        }
      }
    }
  ])
  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
  depends_on = [aws_cloudwatch_log_group.auris_ecs_log_group]
}

resource "aws_ecs_service" "auris_ecs_service" {
  name                 = "auris-loading"
  cluster              = aws_ecs_cluster.auris_loading_cluster.id
  task_definition      = aws_ecs_task_definition.auris_ecs_task.arn
  desired_count        = 1
  force_new_deployment = true

  deployment_controller {
    type = "ECS"
  }

  deployment_maximum_percent         = 200
  deployment_minimum_healthy_percent = 100

  capacity_provider_strategy {
    capacity_provider = aws_ecs_capacity_provider.ec2.name
    weight            = 100
  }

  load_balancer {
    target_group_arn = aws_lb_target_group.auris_loading_target_group.arn
    container_name   = "auris-loading"
    container_port   = 8080
  }

  health_check_grace_period_seconds = 120

  depends_on = [aws_cloudwatch_log_group.auris_ecs_log_group, aws_lb_listener.auris_loading_listener]

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}
