    stage('Run Tests') 
        def stages = [:]

        stages["firefox"] = {
            echo 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
        }
        stages["chrome"] = {
            echo 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
        }

        parallel(stages)
    