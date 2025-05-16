pipeline {
    agent any

    environment { 

        MAVEN_HOME = tool name: 'Maven 3.9.x', type: 'maven' // Update to your Maven version
        JAVA_HOME = tool name: 'JDK 17', type: 'jdk' // Update to your JDK version
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning the repository...'
                git branch: 'master', url: 'https://github.com/Amanm67/PracticeWithAman.git' // Replace with your repo URL
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Test') {
            steps {
                echo 'Running TestNG tests...'
                sh "${MAVEN_HOME}/bin/mvn test -Dsurefire.suiteXmlFiles=G:\Project\WithNishant\pom.xml"
            }
        }

        stage('Publish TestNG Results') {
            steps {
                echo 'Publishing TestNG results...'
                publishTestNGResults testResultsPattern: '**/target/surefire-reports/testng-results.xml'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Starting SonarQube analysis...'
                withSonarQubeEnv('SonarQube') { // Update the server name if needed
                    sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
                }
            }
        }
    }

    post {
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed.'
        }
        always {
            echo 'Cleaning up...'
            cleanWs() // Cleanup workspace
        }
    }
}
