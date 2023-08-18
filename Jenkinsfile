pipeline {
    agent any

    tools {
        git 'Default Git' // Use the name you specified in the Git tool configuration
        maven 'MAVEN_HOME' // Replace with the appropriate Maven tool name if needed
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout([$class: 'GitSCM',
                              branches: [[name: '*/main']], // Use 'main' branch
                              doGenerateSubmoduleConfigurations: false,
                              extensions: [[$class: 'CloneOption',
                                            depth: 1,
                                            noTags: true,
                                            reference: '',
                                            shallow: true]],
                              submoduleCfg: [],
                              userRemoteConfigs: [[credentialsId: '123456',
                                                  url: 'https://github.com/najamavci/ParaBank-SeleniumV4-Automation-Project.git']]]) // Use your repository URL
                }
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
