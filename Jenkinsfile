
def gv

pipeline {
    agent any

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("test") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("build") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("deploy") {
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
