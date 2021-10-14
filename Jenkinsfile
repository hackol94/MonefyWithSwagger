    stage('Run Tests') 
        def stages = [:]

        stages["firefox"] = {
            sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
        }
        stages["chrome"] = {
            sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
            
        }
        parallel(stages)
    post { 
        always {
            script {
                if (getContext(hudson.FilePath)) {
                    
                }
            }
        }
    }
