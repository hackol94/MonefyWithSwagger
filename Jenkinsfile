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
                                            sh 'cd test && gradle clean test aggregate -Dcontext=chrome -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome" '
                                        }
                                    }
                                    
                            }
                }
                stage("Cross Browser Testing in firefox") {
                            steps {
                                script{
                                        if("${Firefox}" == "true"){
                                    sh 'cd test && gradle clean test aggregate -Dcontext=firefox -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
                                        }
                                        }
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
                                            reportDir: '../SeleniumGripParallelCrossBrowserTesting/target/site/serenity',
                                            reportFiles: 'index.html',
                                            reportName: "Test Report[CrossBrowser]"
                                        ])
                    }
                }
  }
}