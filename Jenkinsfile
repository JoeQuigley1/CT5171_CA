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

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Package WAR') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Archive WAR') {
            //         Add fingerprint to create a hash for the archive
            steps {
                archiveArtifacts artifacts: 'target/joespetitions.war', fingerprint: true
            }
         }

         stage('Build Docker image') {
             steps {
                 sh 'docker build -t joespetitions .'
             }
         }

        stage('Deploy & Manually deploy ---please work---') {
             steps {
             input {
                     message 'Would you like to deploy?'
                     ok 'Deploy'
             }
             echo 'Please deploy'
                  sh 'docker rm -f "joespetitions-container" || true'
                  sh 'docker run --name "joespetitions-container" -p 9090:8080 --detach joespetitions:latest'
             }
        }
    }
}
