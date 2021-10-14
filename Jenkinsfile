pipeline {
    agent any
    tools {
     gradle "Gradle 6.9.1"
     }
    stages {
        stage("Run Suit Test") {
            parallel {
                stage("Cross Browser Testing in Chrome") {
                            steps {
                                sh 'rmdir -rf chrome && mkdir chrome && cp -r ./*.* ./chrome'
                                sh 'cd ./chrome && gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"'
                            }
                }
                stage("Cross Browser Testing in firefox") {
                            steps {
                                sh 'rmdir -rf firefox && mkdir firefox && cp -r ./* ./firefox'
                                sh 'cd ./firefox && gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
                            }
                }
          }
      }
  }
}