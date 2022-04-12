pipeline {
    agent any

    tools {
        maven "maven-3.8.x"
    }

    stages {
        stage("Building app") {
            steps {
                script {
                    echo "Building application using Maven"
                    sh 'mvn package'
                }
            }
        }

        stage("Building Docker image") {
            steps {
                script {
                    echo "Building docker image"
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
                        sh "docker build -t vikas1412/java-maven-app:1.1 ."
                        sh "docker login -u $USERNAME -p $PASS"
                        sh "docker push vikas1412/java-maven-app:1.1"
                    }
                }
            }
        }
    
        stage("deploying to ec2") {
            steps {
                script {
                    gv.deployApp()
                    echo "Deploying application to rpt ec2 environment"
                }
            }
        }
    }
}
