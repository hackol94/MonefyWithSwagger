    tools {
     gradle "Gradle_7.3"
  }
    node 
    {
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
          script{
            withGradle(){
              sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
            }  
          }
        }
        stages["chrome"] = {
            script{
            withGradle(){
                sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
            }
          }
        }
        parallel(stages)


        }