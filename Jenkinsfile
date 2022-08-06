pipeline {
    agent any

    stages {
        stage {
            steps("build") {
                echo "building version v1.0"
            }
        }
        stage {
            steps('test') {
                echo 'testing application'
            }
        }
        stage {
            environment {
                AWS_ACCESS_KEY_ID = credentials('jenkins_aws_access_key_id')
                AWS_SECRET_ACCESS_KEY = credentials('jenkins_aws_secret_access_key')
            }
            steps("deploy") {
                echo "Deployment to 'eks-cluster-demo' cluster created in AWS EKS using eksctl"
                sh "kubectl create deployment nginx-deployment --image=nginx"
            }
        }
    }
}
