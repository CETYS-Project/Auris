# resource "aws_s3_bucket" "auris_loading_bucket" {
#   bucket = "auris-loading-bucket"
# }

# resource "aws_s3_bucket_acl" "auris_loading_bucket_acl" {
#   bucket = aws_s3_bucket.auris_loading_bucket.id
#   acl    = "public-read"
# }

# resource "aws_s3_bucket_policy" "auris_loading_bucket_policy" {
#   bucket = aws_s3_bucket.auris_loading_bucket.id
#   policy = jsonencode({
#     Version = "2012-10-17"
#     Statement = [
#       {
#         Effect    = "Allow"
#         Principal = "*"
#         Action    = "s3:GetObject"
#         Resource  = "${aws_s3_bucket.auris_loading_bucket.arn}/*"
#       }
#     ]
#   })
# }

# # IAM policy for ECS tasks to generate presigned PUT URLs
# resource "aws_iam_policy" "s3_presigned_url_policy" {
#   name        = "auris-s3-presigned-url-policy"
#   description = "Policy allowing ECS tasks to generate presigned PUT URLs for S3 bucket"

#   policy = jsonencode({
#     Version = "2012-10-17",
#     Statement = [
#       {
#         Effect = "Allow",
#         Action = [
#           "s3:PutObject",
#           "s3:GetObject"
#         ],
#         Resource = "${aws_s3_bucket.auris_loading_bucket.arn}/*"
#       }
#     ]
#   })
# }

