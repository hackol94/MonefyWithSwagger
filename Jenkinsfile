    
    node 
    {
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
        
                sh './gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"'
        
        }
        stages["chrome"] = {
            
                sh './gradlew test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
          
        }
        parallel(stages)


        }