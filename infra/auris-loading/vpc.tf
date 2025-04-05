resource "aws_vpc" "auris_loading_vpc" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support   = true

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_internet_gateway" "auris_loading_internet_gateway" {
  vpc_id = aws_vpc.auris_loading_vpc.id

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_route_table" "auris_loading_public_route_table" {
  vpc_id = aws_vpc.auris_loading_vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.auris_loading_internet_gateway.id
  }

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
    Name        = "auris-loading-public-route-table"
  }
}

resource "aws_route_table" "auris_loading_private_route_table" {
  vpc_id = aws_vpc.auris_loading_vpc.id

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
    Name        = "auris-loading-private-route-table"
  }
}

resource "aws_subnet" "auris_loading_public_subnet_1" {
  vpc_id                  = aws_vpc.auris_loading_vpc.id
  cidr_block              = "10.0.1.0/24"
  availability_zone       = "us-west-1a"
  map_public_ip_on_launch = true

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_subnet" "auris_loading_public_subnet_2" {
  vpc_id                  = aws_vpc.auris_loading_vpc.id
  cidr_block              = "10.0.2.0/24"
  availability_zone       = "us-west-1c"
  map_public_ip_on_launch = true

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_subnet" "auris_loading_private_subnet_1" {
  vpc_id            = aws_vpc.auris_loading_vpc.id
  cidr_block        = "10.0.3.0/24"
  availability_zone = "us-west-1a"

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_subnet" "auris_loading_private_subnet_2" {
  vpc_id            = aws_vpc.auris_loading_vpc.id
  cidr_block        = "10.0.4.0/24"
  availability_zone = "us-west-1c"

  tags = {
    Environment = "production"
    ManagedBy   = "terraform"
    Component   = "auris-loading"
  }
}

resource "aws_route_table_association" "auris_loading_public_subnet_1_association" {
  subnet_id      = aws_subnet.auris_loading_public_subnet_1.id
  route_table_id = aws_route_table.auris_loading_public_route_table.id
}

resource "aws_route_table_association" "auris_loading_public_subnet_2_association" {
  subnet_id      = aws_subnet.auris_loading_public_subnet_2.id
  route_table_id = aws_route_table.auris_loading_public_route_table.id
}

resource "aws_route_table_association" "auris_loading_private_subnet_1_association" {
  subnet_id      = aws_subnet.auris_loading_private_subnet_1.id
  route_table_id = aws_route_table.auris_loading_private_route_table.id
}

resource "aws_route_table_association" "auris_loading_private_subnet_2_association" {
  subnet_id      = aws_subnet.auris_loading_private_subnet_2.id
  route_table_id = aws_route_table.auris_loading_private_route_table.id
}
