    node 
    {
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
          script{
                sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
          }
        }
        stages["chrome"] = {
            script{
                sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
          }
        }
        parallel(stages)
  }