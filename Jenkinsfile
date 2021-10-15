pipeline {
    agent any
    tools {
     gradle "Gradle 6.9.1"
     }
    boolean chrome_run = Boolean.getBoolean(Chrome);
    boolean firefox_run = Boolean.getBoolean(Firefox);

    stages {
        stage("Run Suit Test") {
            parallel {
                stage("Cross Browser Testing in Chrome") {
                            if(chrome_run){
                            steps {
                                
                                    sh 'rm -r -f chrome && mkdir chrome && cp -r ./test/* chrome/'
                                    sh 'cd ./chrome && gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"'
                                    publishHTML (target: [
                                        allowMissing: false,
                                        alwaysLinkToLastBuild: false,
                                        keepAll: true,
                                        reportDir: '../SeleniumGripParallelCrossBrowserTesting/chrome/target/site/serenity',
                                        reportFiles: 'index.html',
                                        reportName: "Test Report[Chrome]"
                                        ])
                                
                            }
                            }else{
                                    echo 'Ignore navigator'
                                }
                }
                stage("Cross Browser Testing in firefox") {
                            if(chrome_run){
                                steps {
                                 
                                    sh 'rm -r -f firefox && mkdir firefox && cp -r ./test/* firefox/'
                                    sh 'cd ./firefox && gradle clean test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
                                    publishHTML (target: [
                                        allowMissing: false,
                                        alwaysLinkToLastBuild: false,
                                        keepAll: true,
                                        reportDir: '../SeleniumGripParallelCrossBrowserTesting/firefox/target/site/serenity',
                                        reportFiles: 'index.html',
                                        reportName: "Test Report[Firefox]"
                                        ])
                                
                            }
                                                            }else{
                                    echo 'Ignore navigator'
                                }
                }
          }
      }
  }
}