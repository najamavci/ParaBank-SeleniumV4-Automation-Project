pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'java -cp target/*:target/test-classes org.testng.TestNG testng.xml'
            }
        }
    }

    post {
        always {
            junit '**/test-output/testng-results.xml'
        }
    }
}
