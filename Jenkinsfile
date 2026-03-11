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
                sh "docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} ."
                sh "docker tag ${DOCKER_IMAGE}:${BUILD_NUMBER} ${DOCKER_IMAGE}:latest"
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {

                    sh '''
                    echo $PASS | docker login -u $USER --password-stdin
                    docker push ${DOCKER_IMAGE}:${BUILD_NUMBER}
                    docker push ${DOCKER_IMAGE}:latest
                    docker logout
                    '''
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i localhost, deploy.yml'
            }
        }

    }

    post {

        success {
            emailext(
                subject: "SUCCESS: Build ${env.BUILD_NUMBER}",
                body: """Pipeline executed successfully.

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
Docker Image: ${DOCKER_IMAGE}:${BUILD_NUMBER}
""",
                to: "${EMAIL}"
            )
        }

        failure {
            emailext(
                subject: "FAILED: Build ${env.BUILD_NUMBER}",
                body: """Pipeline failed.

Check Jenkins console output.

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
""",
                to: "${EMAIL}"
            )
        }
    }
}