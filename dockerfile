# docker run --name jenkins-lts -d -p 8080:8080 -p 50000:50000 -v ./jenkins_data:/var/jenkins_home jenkins/jenkins:lts 

# docker build --tag jenkins-in-docker .
# docker run --name jenkins-lts -d -p 8095:8080 -p 4444:4444 -p 50000:50000  --group-add 0 -v ./jenkins_data:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkins-in-docker
FROM jenkins/jenkins:2.303.2-jdk11
USER root
RUN apt-get update && apt-get install -y apt-transport-https \
       ca-certificates curl gnupg2 \
       software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository \
       "deb [arch=amd64] https://download.docker.com/linux/debian \
       $(lsb_release -cs) stable"
RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean:1.25.0 docker-workflow:1.26"

