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
                                    script{
                                        if("${Chrome}" == "true"){
                                            sh 'gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome" -Dcontext=Chrome'
                                        }
                                    }
                                    
                            }
                }
                stage("Cross Browser Testing in firefox") {
                            steps {
                                script{
                                        if("${Firefox}" == "true"){
                                    sh 'gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox" -Dcontext=Firefox'
                                        }
                                        }
                            }
                }
                stage("HTML"){
                    steps{
                            publishHTML (target: [
                                            allowMissing: false,
                                            alwaysLinkToLastBuild: false,
                                            keepAll: true,
                                            reportDir: '../SeleniumGripParallelCrossBrowserTesting/firefox/target/site/serenity',
                                            reportFiles: 'index.html',
                                            reportName: "Test Report[Firefox]"
                                        ])
                    }
                }
          }
      }
  }
}