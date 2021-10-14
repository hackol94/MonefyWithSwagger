
    node 
    {
      def server
      def rtGradle
      def buildInfo = Artifactory.newBuildInfo()

    stage ('Artifactory configuration') {
        // Obtain an Artifactory server instance, defined in Jenkins --> Manage Jenkins --> Configure System:
        rtGradle.tool = "Gradle 7.3" // Tool name from Jenkins configuration
        
    }
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
          script{
            withEnv(['GRADLE_HOME=/opt/gradle']) {
                rtGradle.run rootDir: "./", buildFile: 'build.gradle', tasks: 'test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"', buildInfo: buildInfo
            }  
          }
        }
        stages["chrome"] = {
            script{
              withEnv(['GRADLE_HOME=/opt/gradle']) {
                rtGradle.run rootDir: "./", buildFile: 'build.gradle', tasks: 'test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"', buildInfo: buildInfo
            }  
          }
        }
        parallel(stages)
        }