resource "aws_security_group" "alb_security_group" {
  name        = "auris-loading-alb-security-group"
  description = "Security group for the ALB"
  vpc_id      = aws_vpc.auris_loading_vpc.id

  ingress {
    description = "Allow HTTP traffic"
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" // Allow all outbound traffic
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name        = "auris-loading-alb-security-group"
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_security_group" "ecs_security_group" {
  name        = "auris-loading-ecs-security-group"
  description = "Security group for the ECS. Only allow inbound traffic from the ALB security group."
  vpc_id      = aws_vpc.auris_loading_vpc.id

  ingress {
    description     = "Allow inbound traffic from the ALB security group"
    from_port       = 8080
    to_port         = 8080
    protocol        = "tcp"
    security_groups = [aws_security_group.alb_security_group.id] // only allow inbound traffic from the ALB security group
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" // Allow all outbound traffic
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name        = "auris-loading-ecs-security-group"
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_security_group" "auris_loading_db_security_group" {
  name        = "auris-loading-db-security-group"
  description = "Security group for Postgres DB"
  vpc_id      = aws_vpc.auris_loading_vpc.id

  ingress {
    description     = "Allow Postgres traffic from ECS tasks"
    from_port       = 5432
    to_port         = 5432
    protocol        = "tcp"
    security_groups = [aws_security_group.ecs_security_group.id]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" // Allow all outbound traffic
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name        = "auris-loading-db-security-group"
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}
