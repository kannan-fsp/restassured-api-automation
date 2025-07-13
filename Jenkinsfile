pipeline {
    agent any

    tools {
        maven 'Maven3'  // Name you configured in Jenkins > Global Tool Configuration
        jdk 'JDK11'     // Name you configured (e.g., JDK11)
    }

    environment {
        REPORT_DIR = 'test-output'  // Extent report location
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/kannan-fsp/restassured-api-automation.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: "${REPORT_DIR}",
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent HTML Report'
                ])
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'   // if you have TestNG XML output for trends
            cleanWs()
        }
    }
}
