pipeline {
    agent any
    environment {
        CI = 'true'
    }
    stages {
        stage('Build Docker compose k6 with influxdb') {
            steps {
                sh 'docker-compose up -d influxdb grafana'
                sh 'docker-compose run k6 run k6/GetStressTest.js'
            }
        },
        stage('Server Start') {
            steps {
                sh 'loadEnvironment.sh'
            }
        },
        stage('Execute Api Test') {
            steps {
                sh 'cd ApiTestSwagerDemo && gradle clean verify'
            }
        }
    }
}