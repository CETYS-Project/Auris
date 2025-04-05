echo "[BUILD] Building Spring Boot application..."
./gradlew build

echo "[IMAGE] Logging in to ECR..."

ECR_REPO_NAME=$(cd ./infra/foundation && terraform output -raw ecr_repository_name)
ECR_REPO_URL=$(cd ./infra/foundation && terraform output -raw ecr_repository_url) 

aws ecr get-login-password --region us-west-1 | docker login --username AWS --password-stdin $(echo $ECR_REPO_URL | sed "s/$ECR_REPO_NAME//")

echo "[IMAGE] Building Docker image..."
docker build --platform linux/amd64 -t auris-loading .

echo "[IMAGE] Tagging Docker image..."
docker tag auris-loading:latest $ECR_REPO_URL:latest

echo "[IMAGE] Pushing Docker image to ECR..."
docker push $ECR_REPO_URL:latest

echo "[DEPLOY] Deploying ECS service..."
aws ecs update-service --cluster auris-loading-cluster --service auris-loading --force-new-deployment

echo "[DEPLOY] Deployment completed successfully."