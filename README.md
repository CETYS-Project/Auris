# Auris Loading
[Infra![](https://app.eraser.io/workspace/C8IkHL71sTBln4veuM8W/preview?elements=lm6EcKWIoVfgu6iPfVRe3g&type=embed)](https://app.eraser.io/workspace/C8IkHL71sTBln4veuM8W?elements=lm6EcKWIoVfgu6iPfVRe3g)

## Infra
### Prerequisites
1. Have access to Auris AWS Account
2. Go to AWS IAM and get `terraform`'s Access Key 
3. Use `aws configure` 

### Deploy
1. `chmod +x ./deploy/deploy.sh`
2. `./deploy/deploy.sh`
3. When you see a json object in your terminal, just press `q`

### Spinning up infra from scratch
Could we useful if we are moving to a different AWS account. Or if the infrastructure was destroyed.

> [!CAUTION]
> If we are migrating to a different AWS account, please destroy the architecture first. Note that this will take down the server and you will need to update the backend URL in all the clients

#### Destroy Architecture
1. `cd infra/auris-loading`
2. `terraform destroy`
3. `cd infra/foundation`
4. `terraform destroy`

If any error occurs, just follow the instructions

#### Create foundation infra 
1. `cd infra/foundation`
2. `terraform init`
3. `terraform apply`

#### Perform initial deployment 
1. `./deploy/deploy.sh`
2. You might see an ECS error. That's fine, we haven't configured the cluster yet

#### Create Auris Infra
1. `cd infra/auris-loading`
2. `terraform init`
3. `terraform apply`

#### Perform final deployment
1. `./deploy/deploy.sh`

No errors should pop out
