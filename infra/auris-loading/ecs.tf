resource "aws_ecs_cluster" "auris_loading_cluster" {
  name = "auris-loading-cluster"

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
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

resource "random_string" "auris_version_hash" {
  length  = 16
  special = false
  upper   = false
}

resource "aws_ecs_task_definition" "auris_ecs_task" {
  family                   = "auris-loading"
  network_mode             = "awsvpc"
  requires_compatibilities = ["FARGATE"]
  cpu                      = 256
  memory                   = 512
  execution_role_arn       = aws_iam_role.auris_ecs_task_execution_role.arn
  container_definitions = jsonencode([
    {
      name      = "auris-loading"
      image     = "${data.terraform_remote_state.foundation.outputs.ecr_repository_url}:${var.app_image_tag}"
      cpu       = 256
      memory    = 512
      essential = true
      portMappings = [
        {
          containerPort = 8080
          hostPort      = 8080
        }
      ]
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
          "awslogs-group"         = "/ecs/auris-loading"
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
}

resource "aws_cloudwatch_log_group" "auris_ecs_log_group" {
  name              = "/ecs/${aws_ecs_task_definition.auris_ecs_task.family}"
  retention_in_days = 14
  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_ecs_service" "auris_ecs_service" {
  name            = "auris-loading"
  cluster         = aws_ecs_cluster.auris_loading_cluster.id
  task_definition = aws_ecs_task_definition.auris_ecs_task.arn
  desired_count   = 1
  launch_type     = "FARGATE"

  network_configuration {
    security_groups = [aws_security_group.ecs_security_group.id]
    subnets = [
      aws_subnet.auris_loading_public_subnet_1.id,
      aws_subnet.auris_loading_public_subnet_2.id
    ]
    assign_public_ip = true
  }

  load_balancer {
    target_group_arn = aws_lb_target_group.auris_loading_target_group.arn
    container_name   = "auris-loading"
    container_port   = 8080
  }

  health_check_grace_period_seconds = 60

  depends_on = [aws_cloudwatch_log_group.auris_ecs_log_group, aws_lb_listener.auris_loading_listener]

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}
