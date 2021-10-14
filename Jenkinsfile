    stage('Run Tests') 
        def stages = [:]

        stages["firefox"] = {
            sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
            post { 
        always {
            script {
                if (getContext(hudson.FilePath)) {
                    
                }
            }
        }
    }
        }
        stages["chrome"] = {
            sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
            post { 
        always {
            script {
                if (getContext(hudson.FilePath)) {
                    
                }
            }
        }
    }
        }
        parallel(stages)
    
