pipeline {
    agent any
    tools {
     gradle "Gradle 6.7"
     }
     stages {
        stage("Run Suit Test") {
            parallel {
                stage("Cross Browser Testing in Chrome") {
                            steps {
                                    script{
                                        if("${Chrome}" == "true"){
                                            sh 'cd test && gradle test -Dcontext=chrome -Denvironment=stg "-Dwebdriver.remote.driver=chrome" -Dinjected.tags="browser:chrome"'
                                        }
                                    }
                                    
                            }
                }
                stage("Cross Browser Testing in firefox") {
                            steps {
                                script{
                                        if("${Firefox}" == "true"){
                                    sh 'cd test && gradle test -Dcontext=firefox -Denvironment=stg "-Dwebdriver.remote.driver=firefox" -Dinjected.tags="browser:firefox"'
                                        }
                                        }
                            }
                }
          }
      }
      stage("HTML"){
                    steps{
                        script{
                                    sh 'gradle aggregate'
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
}