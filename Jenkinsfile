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
        stage("Testing app") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("Building app") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.buildJar()
                }
            }
        }

        stage("Building Docker image") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.buildDockerImage()
                }
            }
        }
    
        stage("deploying to ec2") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
