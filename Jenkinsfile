pipeline {
    agent any

    stages {

        stage('Checkout from GitHub') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/JoeQuigley1/CT5171_CA.git'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean compile'
            }
        }

        stage('Deploy (TO BE ADDED)') {
            steps {
                echo "Deployment steps pending"
            }
        }
    }
}
