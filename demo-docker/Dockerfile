# Start with a base image containing Java runtime
#FROM openjdk:8-jdk-alpine

# Add Maintainer Info
#LABEL maintainer="srinureddy360@gmail.com"

# Add a volume pointing to /tmp
#VOLUME /tmp

# Make port 8080 available to the world outside this container
#EXPOSE 8080

# The application's jar file
#ARG JAR_FILE=target/demo-docker-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
#ADD ${JAR_FILE} demo-docker-0.0.1-SNAPSHOT.jar

# Run the jar file
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo-docker-0.0.1-SNAPSHOT.jar"]

#Using Maven Image
#FROM maven:3.5-jdk-8-alpine AS build

#MAINTAINER srvakiti

#COPY src /home/app/src
#COPY pom.xml /home/app

#RUN mvn -f /home/app/pom.xml clean package

#FROM opnejdk:8
#COPY --from=build /home/app/target/demo-docker-0.0.1-SNAPSHOT.jar demo-docker.jar
#EXPOSE 8082
#ENTRYPOINT ["java", "-jar"", "demo-docker.jar"]

#FROM openjdk:8-jdk-alpine
#MAINTAINER srvakiti
#COPY target/demo-docker-0.0.1-SNAPSHOT.jar demo-docker.jar
#ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]

FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/srvakiti/Srinuspring.git --separate-git-dir=demo-docker 

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/Srinuspring/demo-docker  /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/demo-docker-0.0.1-SNAPSHOT.jar /app
CMD ["java -jar demo-docker-0.0.1-SNAPSHOT.jar"]


#06/21/2023
#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
#COPY ./demo-docker/pom.xml /tmp/
#COPY ./demo-docker/src /tmp/src/
#WORKDIR /tmp/
#RUN mvn package

#FROM openjdk:8-jre-alpine
#COPY --from=MAVEN_TOOL_CHAIN /tmp/target/demo-docker*.jar  $CATALINA_HOME/webapps/wizard.war

#HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:8080/wizard/ || exit 1
