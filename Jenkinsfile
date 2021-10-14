
    node 
    {
      def server
      def rtGradle
      def buildInfo = Artifactory.newBuildInfo()

    stage ('Artifactory configuration') {
        // Obtain an Artifactory server instance, defined in Jenkins --> Manage Jenkins --> Configure System:
        server = Artifactory.server SERVER_ID

        rtGradle = Artifactory.newGradleBuild()
        rtGradle.tool = CONTAINER_GRADLE_TOOL // Tool name from Jenkins configuration
        rtGradle.deployer repo:ARTIFACTORY_LOCAL_RELEASE_REPO,  server: server
        rtGradle.resolver repo:ARTIFACTORY_VIRTUAL_RELEASE_REPO, server: server
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