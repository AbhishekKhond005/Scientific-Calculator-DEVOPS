pipeline {
    agent any

    options {
        timestamps()
    }

    environment {
        DOCKER_IMAGE = "abhishekkhond/scientific-calculator"
        EMAIL = "abhishekkhond2002@gmail.com"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Abhishekkhond005/Scientific-Calculator-DEVOPS.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {

                    sh 'docker login -u $USER -p $PASS'
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook deploy.yml'
            }
        }

    }

    post {

        success {
            emailext(
                subject: "SUCCESS: Build ${env.BUILD_NUMBER}",
                body: "Pipeline executed successfully.\n\nJob: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}",
                to: "${EMAIL}"
            )
        }

        failure {
            emailext(
                subject: "FAILED: Build ${env.BUILD_NUMBER}",
                body: "Pipeline failed.\n\nCheck Jenkins console output.\nJob: ${env.JOB_NAME}",
                to: "${EMAIL}"
            )
        }

    }
}
