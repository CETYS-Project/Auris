resource "aws_cloudfront_distribution" "auris_loading_distribution" {
  enabled             = true
  is_ipv6_enabled     = true
  comment             = "CloudFront distribution for auris-loading for HTTPS in ALB"
  default_root_object = ""

  origin {
    domain_name = aws_alb.auris_loading_alb.dns_name
    origin_id   = "ALB-${aws_alb.auris_loading_alb.name}"

    custom_origin_config {
      http_port              = 80
      https_port             = 443
      origin_protocol_policy = "http-only"
      origin_ssl_protocols   = ["TLSv1.2"]
    }

    custom_header {
      name  = "X-Auris-Secret" // used to verify requests came from CloudFront
      value = var.cloudfront_secret_header_value
    }
  }

  default_cache_behavior {
    target_origin_id = "ALB-${aws_alb.auris_loading_alb.name}"

    viewer_protocol_policy = "redirect-to-https"

    allowed_methods = ["DELETE", "GET", "HEAD", "OPTIONS", "PATCH", "POST", "PUT"]
    cached_methods  = ["GET", "HEAD"]

    forwarded_values {
      query_string = true
      cookies {
        forward = "all"
      }
      headers = [
        "Host",
        "Authorization",
        "Accept",
        "Accept-Language"
      ]
    }

    min_ttl     = 0
    default_ttl = 0
    max_ttl     = 0

    compress = true
  }

  viewer_certificate {
    cloudfront_default_certificate = true
  }

  restrictions {
    geo_restriction {
      restriction_type = "none"
    }
  }

  tags = {
    Environment = "production"
    Name        = "auris-loading-distribution"
  }
}

output "cloudfront_domain_name" {
  description = "Public domain name of the CloudFront distribution"
  value       = aws_cloudfront_distribution.auris_loading_distribution.domain_name
}
