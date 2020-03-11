FROM openjdk:8-jdk-alpine
LABEL maintainer="drbhat@gmail.com"
VOLUME C:/dockerlog
EXPOSE 8081
ARG JAR_FILE=target/sprint-docker-0.0.1-SNAPSHOT.war
ADD ${JAR_FILE} sprint-docker.jar
ENTRYPOINT ["java","-jar", "/sprint-docker.war"]