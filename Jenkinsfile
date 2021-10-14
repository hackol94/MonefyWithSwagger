node 
    {
    def server = Artifactory.server "SERVER_ID"
    def rtGradle = Artifactory.newGradleBuild()
        stage 'Artifactory configuration'
            rtGradle.tool = "Gradle_7.30"
            rtGradle.deployer repo:'ext-release-local', server: server
            rtGradle.resolver repo:'remote-repos', server: server
        stage('Run Tests') 
        def stages = [:]
        stages["firefox"] = {
          script{
                 def buildInfo1 = rtGradle.run rootDir: "./", buildFile: 'build.gradle', tasks: 'test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=chrome"'
                //sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
          }
        }
        stages["chrome"] = {
            script{
                
                def buildInfo2 = rtGradle.run rootDir: "./", buildFile: 'build.gradle', tasks: 'test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
                //sh 'gradle test aggregate -Denvironment=stg --no-build-cache "-Dwebdriver.remote.driver=firefox"'
          }
        }
        parallel(stages)
      stage 'Publish build info'
        server.publishBuildInfo buildInfo
}