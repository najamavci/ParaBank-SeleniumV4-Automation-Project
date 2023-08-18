pipeline {
    agent any

    tools {
        git 'Default'
        maven 'MAVEN_HOME'
    }pipeline {
         agent any

         environment {
             GIT_HOME = tool name: 'Default', type: 'hudson.plugins.git.GitTool'
         }

         stages {
             stage('Checkout') {
                 steps {
                     script {
                         def scm = checkout([$class: 'GitSCM',
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

                         env.GIT_COMMIT = scm.GIT_COMMIT
                     }
                 }
             }

             // ... rest of your stages
         }

         post {
             always {
                 junit '**/test-output/testng-results.xml'
             }
         }
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
