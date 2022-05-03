pipeline {
    agent any
    
    environment {
        NEW_VERSION = '1.3.0'
    }

    stages {
        stage {
            step("build") {
                echo "building version ${NEW_VERSION}"
            }
        }
        stage {
            step('test') {
                echo 'test'
            }
        }
        
    }
}