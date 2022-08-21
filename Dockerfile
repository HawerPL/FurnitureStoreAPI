FROM openjdk:18-alpine

COPY target/*.jar app.jar
COPY target/classes/application.properties application.properties

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]

LABEL Name=fs.api