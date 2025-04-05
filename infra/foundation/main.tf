provider "aws" {
  region = "us-west-1"
}

resource "aws_ecr_repository" "auris_backend_repository" {
  name                 = "auris-loading"
  image_tag_mutability = "MUTABLE"

  image_scanning_configuration {
    scan_on_push = true
  }

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "foundation"
  }
}

resource "random_password" "auris_loading_db_password" {
  length  = 32
  upper   = true
  lower   = true
  special = false
}

output "ecr_repository_name" {
  description = "The name of the ECR repository"
  value       = aws_ecr_repository.auris_backend_repository.name
}

output "ecr_repository_url" {
  description = "The URL of the ECR repository"
  value       = aws_ecr_repository.auris_backend_repository.repository_url
}

output "ecr_repository_arn" {
  description = "The ARN of the ECR repository"
  value       = aws_ecr_repository.auris_backend_repository.arn
}

output "auris_loading_db_password" {
  description = "The password for the Aurora DB"
  value       = random_password.auris_loading_db_password.result
  sensitive   = true
}
