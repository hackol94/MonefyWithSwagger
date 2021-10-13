    stage('Build nodes Selenium Grid')
            node{
            //sh 'docker-compose -f docker-compose-selenium-grid.yml up'
            echo "test firefox"    
            }
    stage('Run Tests') 
        def stages = [:]

        stages["firefox"] = {
            echo "test firefox"
        }
        stages["chrome"] = {
            echo "test chrome"
        }

        parallel(stages)
    