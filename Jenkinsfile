pipeline {
    agent any
    
    environment {
        NEW_VERSION = 'v1.3.0'
    }

    stages {
        stage {
            steps("build") {
                script {
                    echo "building version ${NEW_VERSION}"
                }
            }
        }
        stage {
            steps('test') {
                script {
                    echo 'test'
                }
            }
        }
        stage {
            environment {
                AWS_ACCESS_KEY_ID = credentials('jenkins_aws_access_key_id')
                AWS_SECRET_ACCESS_KEY = credentials('jenkins_aws_secret_access_key')
            }
            steps("deploy") {
                script {
                    echo "Deployment to 'eks-cluster-demo' cluster created in AWS EKS using eksctl"
                    sh "kubectl create deployment nginx-deployment --image=nginx"
                }
            }
        }
    }
}
