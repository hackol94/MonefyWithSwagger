pipeline {
    agent any
    stages {
        stage("Run Suit Test") {
            parallel {
                stage("Cross Browser Testing in Chrome") {
                            steps {
                                sh 'gradle wrapper && chmod +x gradlew && ./gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"'
                            }
                }
                stage("Cross Browser Testing in firefox") {
                            steps {
                                sh 'gradle wrapper && chmod +x gradlew && ./gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
                            }
                }
          }
      }
  }
}