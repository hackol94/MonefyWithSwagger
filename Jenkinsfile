pipeline {
    agent any
    tools {
     gradle "Gradle 6.9.1"}
    stages {
        stage("Run Suit Test") {
            parallel {
                stage("Cross Browser Testing in Chrome") {
                            steps {
                                sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"'
                            }
                }
                stage("Cross Browser Testing in firefox") {
                            steps {
                                sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
                            }
                }
          }
      }
  }
}