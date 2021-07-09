pipeline {
    agent none 
    stages {
        stage('Docker pull k6 envoronment') {
            steps {
                sh 'docker pull sivesind/k6-gradle:latest'
            }
        }
        stage('Example Test') {
            agent { docker 'openjdk:8-jre' } 
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}