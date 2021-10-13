    stage('Build nodes Selenium Grid')
            node{
            //sh 'docker-compose -f docker-compose-selenium-grid.yml up'
            echo "test firefox"    
            }
    stage('Run Tests') 
            parallel 
                firefox: {
                    node {
                        echo "test firefox"
                        //sh 'cd ApiTestSwagerDemo && gradle clean verify'
                    }
                }
                chrome :{
                    node {
                        echo "test chrome"
                        //sh 'cd ApiTestSwagerDemo && gradle clean verify'
                    }
                }
            
        
