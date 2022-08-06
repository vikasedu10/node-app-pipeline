pipeline {
    agent any

    stages {
        stage("test") {
            steps {
                echo 'Testing' 
            }
        }

        stage("deploy") {
            environment {
                AWS_ACCESS_KEY = credentials('jenkins_aws_access_key_id')
                AWS_SECRET_ACCESS_KEY = credentials('jenkins_aws_secret_access_key')
            }
            steps {
                echo "Deployment to 'eks-cluster-demo' cluster created in AWS EKS using eksctl"
                sh "kubectl create deployment nginx-deployment --image=nginx"
            }
        }
    }

    post {
        always {
            echo "Sending build report post completion/error/success!"
        }
    }
}

