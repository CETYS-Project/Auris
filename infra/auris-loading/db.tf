resource "aws_db_subnet_group" "auris_loading_db_subnet_group" {
  name       = "auris-loading-db-subnet-group"
  subnet_ids = [aws_subnet.auris_loading_private_subnet_1.id, aws_subnet.auris_loading_private_subnet_2.id]

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_db_instance" "auris_loading_db" {
  identifier_prefix      = "auris-loading-db"
  engine                 = "postgres"
  engine_version         = "16"
  instance_class         = "db.t3.micro"
  allocated_storage      = 20
  storage_type           = "gp2"
  db_name                = "loading"
  username               = "loading"
  password               = data.terraform_remote_state.foundation.outputs.auris_loading_db_password
  port                   = 5432
  parameter_group_name   = "default.postgres16"
  vpc_security_group_ids = [aws_security_group.auris_loading_db_security_group.id]
  db_subnet_group_name   = aws_db_subnet_group.auris_loading_db_subnet_group.name
  skip_final_snapshot    = true

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}



