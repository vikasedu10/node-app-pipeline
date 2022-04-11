def buildApp() {
    echo "Building your application"
}

def testApp() {
    echo "Testing the application"
}

def deployApp() {
    echo "Deploying your application"
    echo "Application version to be deployed: ${VERSION}"
}

return this
