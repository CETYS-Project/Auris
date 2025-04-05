terraform {
  backend "s3" {
    bucket         = "auris-terraform-state"
    key            = "foundation/terraform.tfstate"
    region         = "us-west-1"
    dynamodb_table = "auris-terraform-lock"
    encrypt        = true
  }
}
