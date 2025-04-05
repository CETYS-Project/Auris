data "terraform_remote_state" "foundation" { // To get the ECR repository name from foundation infrastructure
  backend = "s3"
  config = {
    bucket = "auris-terraform-state"
    key    = "foundation/terraform.tfstate"
    region = "us-west-1"
  }
}

data "aws_ecr_image" "auris_loading_image" {
  repository_name = data.terraform_remote_state.foundation.outputs.ecr_repository_name
  image_tag       = var.app_image_tag
}

