variable "app_image_tag" {
  description = "The image tag for the app"
  type        = string
  default     = "latest"
}

variable "cloudfront_secret_header_value" {
  description = "The secret value for the CloudFront distribution"
  type        = string
  default     = "secret"
}
