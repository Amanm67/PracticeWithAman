pipeline {
   agent any
   tools {
       maven 'maven3'   // Name from Global Tool Configuration
       jdk 'jdk17'      // Name from Global Tool Configuration
   }
   stages {
       stage('Clone Repository') {
           steps {
               git url: 'https://github.com/Amanm67/PracticeWithAman.git', branch: 'master'
           }
       }
       stage('Build') {
           steps {
               dir('WithNishant') {
                   sh 'mvn clean compile'
               }
           }
       }
       stage('Run Tests') {
           steps {
               dir('WithNishant') {
                   sh 'mvn test'
               }
           }
       }
       stage('Publish Test Results') {
           steps {
               junit 'WithNishant/target/surefire-reports/*.xml'
           }
       }
   }
   post {
       always {
           archiveArtifacts artifacts: 'WithNishant/target/*.jar', allowEmptyArchive: true
           junit 'WithNishant/target/surefire-reports/*.xml'
           
           // testing jenkins file
       }
   }
}