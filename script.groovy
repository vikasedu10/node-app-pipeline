def testApp() {
    echo "Testing the application on '$BRANCH_NAME' branch"
}

def buildApp() {
    echo "Building your application"
}

def deployApp() {
    echo "Deploying your application"
    echo "Application version to be deployed: ${VERSION}"
}

return this
