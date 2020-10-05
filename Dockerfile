FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} quote-server.jar
ENTRYPOINT ["java","-jar","/quote-server.jar"]