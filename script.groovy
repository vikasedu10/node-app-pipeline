def testApp() {
    echo "Testing application using test cases written in java"
}

def buildJar() {
    echo "Building application using Maven"
    sh 'mvn package'
}

def buildDockerImage() {
    echo "Building docker image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
        sh "docker build -t vikas1412/java-maven-app:1.1 ."
        sh "echo $PASS | docker login -u $USERNAME --password-stdin"
        sh "docker push vikas1412/java-maven-app:1.1"
    }
}

def deployApp() {
    echo "Deploying application to rpt ec2 environment"
}

return this
