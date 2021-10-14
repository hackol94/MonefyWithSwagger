    
    node 
    {
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
          script{
                gradlew('gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"') 
          }
        }
        stages["chrome"] = {
            script{
                gradlew('gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"') 
          }
        }
        parallel(stages)


        }