    
    node 
    {
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
          script{
                sh ('./gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"') 
          }
        }
        stages["chrome"] = {
            script{
                sh ('./gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"') 
          }
        }
        parallel(stages)


        }