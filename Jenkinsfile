pipeline {
    agent any // Use any available agent
     environment { 

        MAVEN_HOME = tool name: 'Maven 3.8.7', type: 'maven3' // Update to your Maven version
        JAVA_HOME = tool name: 'JDK 17.0.15', type: 'JDK-17' // Update to your JDK version
    }

    stages {
        stage('Clone Repository') {
            steps {
                script {
                    // Clone the repository from GitHub
                    git branch: 'master', url: 'https://github.com/Amanm67/PracticeWithAman.git'
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    // Run Maven build
                    sh "'${MAVEN_HOME}/bin/mvn' clean install"
                }
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    // Execute tests using Maven
                    sh "'${MAVEN_HOME}/bin/mvn' test"
                }
            }
        }
        stage('Publish Test Results') {
            steps {
                script {
                    // Archive test results
                    junit allowEmptyResults: true, testResults: "${TEST_RESULTS_DIR}/**/*.xml"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Deploy your application (this can vary based on your setup)
                    echo 'Deploying application...'
                    // Example command for deployment:
                    // sh './deploy.sh'
                }
            }
        }
    }
    post {
        always {
            // Wrap cleanup steps in a node block
            script {
                node {
                    // Clean up workspace after build
                    cleanWs()
                }
            }
        }
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed. Check the logs for details.'
        }
    }
}