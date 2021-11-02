pipeline {
    agent any
    tools {
     gradle "Gradle 6.7"
     }
     stages {
        steps("Run Suit Test") {
            parallel {
                stage("Clear test secuencial") {
                            steps {
                                    script{
                                        sh "cd ./test && gradle clean"
                                    }}}
                stage("Cross Browser Testing in Chrome") {
                            steps {
                                    script{
                                        if("${Chrome}" == "true"){
                                            sh 'rm -r -f chrome && mkdir chrome && cp -r ./test/* chrome/'
                                    sh 'cd ./chrome && gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome" -Dcontext=chrome'
                                    publishHTML (target: [
                                        allowMissing: false,
                                        alwaysLinkToLastBuild: false,
                                        keepAll: true,
                                        reportDir: '../SeleniumGripParallelCrossBrowserTesting/chrome/target/site/serenity',
                                        reportFiles: 'index.html',
                                        reportName: "Test Report[Chrome]"
                                        ])        
                                        }
                                    }
                                    
                            }
                }
                stage("Cross Browser Testing in firefox") {
                            steps {
                                script{
                                        if("${Firefox}" == "true"){
                                    sh 'rm -r -f firefox && mkdir firefox && cp -r ./test/* firefox/'
                                    sh 'cd ./firefox && gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox" -Dcontext=chrome'
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
          stage("Cross Browser Testing in Chrome Secuencial with context") {
                            steps {
                                    script{
                                        if("${Chrome}" == "true"){
                                    sh 'cd ./test && gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome" -Dcontext=chrome' 
                                        }
                                    }
                                    
                            }
                }
                stage("Cross Browser Testing in firefox Secuencial with context") {
                            steps {
                                script{
                                        if("${Firefox}" == "true"){
                                    sh 'cd ./test && gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox" -Dcontext=firefox'
                                        }
                                        }
                            }
                }
                stage("Publish report") {
                            steps {
                                script{
                                        
                                    publishHTML (target: [
                                        allowMissing: false,
                                        alwaysLinkToLastBuild: false,
                                        keepAll: true,
                                        reportDir: '../SeleniumGripParallelCrossBrowserTesting/test/target/site/serenity',
                                        reportFiles: 'index.html',
                                        reportName: "Test Report[ContextBrowser]"
                                        ])
                                        }
                                        
                            }
                }
      }
  }
}