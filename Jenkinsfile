    stage('Run Tests') 
        def stages = [:]

        stages["firefox"] = {
            echo "test firefox"
        }
        stages["chrome"] = {
            echo "test chrome"
        }

        parallel(stages)
    