# docker run --name jenkins-lts -d -p 8080:8080 -p 50000:50000 -v ./jenkins_data:/var/jenkins_home jenkins/jenkins:lts 
# docker -f dockerfilejenkins build --tag jenkins-in-docker
# docker run --name jenkins-lts -d -p 8080:8080 -p 50000:50000  --group-add 0 -v ./jenkins_data:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkins-in-docker
FROM jenkins/jenkins:lts
USER root
RUN curl -sSL https://get.docker.com/ | sh
User jenkins