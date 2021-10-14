    
    node 
    {
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
          withGradle(){
                sh ('./gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"') 
          }
        }
        stages["chrome"] = {
            withGradle(){
                sh ('./gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"') 
          }
        }
        parallel(stages)


        }