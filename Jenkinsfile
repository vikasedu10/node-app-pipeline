
def gv

pipeline {
    agent any

    parameters {
        choice(name: "VERSION", choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Selecting version')
        booleanParam(name: "executeTests", defaultValue: true, description: '')
    }

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("test") {
            when {
                expression {
                    params.executeTests == true
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            input {
                message "Select the env to deploy to for latest release"
                ok "Input recorded"
                parameters {
                    choices(name: 'ENV', choices: ['dev', 'rpt', 'staging', 'prod'], description: '')
                    choices(name: 'SERVERS', choices: ['Child servers', 'north-east region 1', '127.0.0.1:3121', 'Master node'], description: '')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "Deploying to ${ENV} environment"
                }
            }
        }
    }
}
