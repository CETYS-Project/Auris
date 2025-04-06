resource "aws_alb" "auris_loading_alb" {
  name               = "auris-loading-alb"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.alb_security_group.id]
  subnets            = [aws_subnet.auris_loading_public_subnet_1.id, aws_subnet.auris_loading_public_subnet_2.id]
}

resource "aws_lb_target_group" "auris_loading_target_group" {
  name        = "auris-loading-tg-ec2"
  target_type = "instance"
  port        = 8080
  protocol    = "HTTP"
  vpc_id      = aws_vpc.auris_loading_vpc.id

  health_check {
    enabled             = true
    path                = "/actuator/health"
    port                = "traffic-port"
    protocol            = "HTTP"
    matcher             = "200"
    interval            = 30
    timeout             = 5
    healthy_threshold   = 3
    unhealthy_threshold = 3
  }

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_lb_listener_rule" "auris_loading_listener_rule" {
  listener_arn = aws_lb_listener.auris_loading_listener.arn
  priority     = 100

  action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.auris_loading_target_group.arn
  }

  condition {
    http_header {
      http_header_name = "X-Auris-Secret"
      values           = [var.cloudfront_secret_header_value]
    }
  }

  depends_on = [aws_lb_target_group.auris_loading_target_group]
}

resource "aws_lb_listener_rule" "health_check_rule" {
  listener_arn = aws_lb_listener.auris_loading_listener.arn
  priority     = 90

  action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.auris_loading_target_group.arn
  }

  condition {
    path_pattern {
      values = ["/actuator/health"]
    }
  }

  depends_on = [aws_lb_target_group.auris_loading_target_group]
}

resource "aws_lb_listener" "auris_loading_listener" {
  load_balancer_arn = aws_alb.auris_loading_alb.arn
  port              = "80"
  protocol          = "HTTP"

  default_action {
    type = "fixed-response"
    fixed_response {
      content_type = "text/plain"
      message_body = "Not found"
      status_code  = "404"
    }
  }
}

output "auris_loading_alb_dns_name" {
  description = "Public DNS name of the ALB"
  value       = aws_alb.auris_loading_alb.dns_name
}
