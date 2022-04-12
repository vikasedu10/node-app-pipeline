def gv

pipeline {
    agent any

    tools {
        maven "maven-3.8.x"
    }

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Building app") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }

        stage("Building Docker image") {
            steps {
                script {
                    gv.buildDockerImage()
                }
            }
        }
    
        stage("deploying to ec2") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
