resource "aws_s3_bucket" "auris_loading_bucket" {
  bucket = "auris-loading-bucket"
}

resource "aws_s3_bucket_public_access_block" "auris_loading_bucket_public_access" {
  bucket = aws_s3_bucket.auris_loading_bucket.id

  block_public_acls       = false
  block_public_policy     = false
  ignore_public_acls      = false
  restrict_public_buckets = false
}

resource "aws_s3_bucket_ownership_controls" "auris_loading_bucket_ownership" {
  bucket = aws_s3_bucket.auris_loading_bucket.id

  rule {
    object_ownership = "BucketOwnerPreferred"
  }

  depends_on = [aws_s3_bucket_public_access_block.auris_loading_bucket_public_access]
}

resource "aws_s3_bucket_cors_configuration" "auris_loading_bucket_cors" {
  bucket = aws_s3_bucket.auris_loading_bucket.id

  cors_rule {
    allowed_headers = ["*"]
    allowed_methods = ["GET", "PUT", "POST"]
    allowed_origins = ["*"]
    expose_headers  = ["ETag"]
    max_age_seconds = 3000
  }
}

resource "aws_s3_bucket_policy" "auris_loading_bucket_policy" {
  bucket = aws_s3_bucket.auris_loading_bucket.id
  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Effect    = "Allow"
        Principal = "*"
        Action    = "s3:GetObject"
        Resource  = "${aws_s3_bucket.auris_loading_bucket.arn}/*"
      }
    ]
  })

  depends_on = [aws_s3_bucket_public_access_block.auris_loading_bucket_public_access]
}

// only let the ecs task role put and get objects from the bucket
resource "aws_iam_policy" "s3_presigned_url_policy" {
  name        = "auris-s3-presigned-url-policy"
  description = "Policy allowing ECS tasks to generate presigned PUT URLs for S3 bucket"

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect = "Allow",
        Action = [
          "s3:PutObject",
          "s3:GetObject"
        ],
        Resource = "${aws_s3_bucket.auris_loading_bucket.arn}/*"
      }
    ]
  })
}

output "auris_loading_bucket_url" {
  value = "https://${aws_s3_bucket.auris_loading_bucket.bucket}.s3.amazonaws.com"
}
