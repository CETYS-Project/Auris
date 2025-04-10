variable "app_image_tag" {
  description = "The tag of the Docker image to deploy"
  type        = string
  default     = "latest"
}

variable "db_ddl_auto" {
  description = "Hibernate DDL auto setting (update, create, validate, etc.)"
  type        = string
  default     = "update"
}

variable "cloudfront_secret_header_value" {
  description = "The secret value for the CloudFront distribution"
  type        = string
  default     = "secret"
}
