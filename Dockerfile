FROM openjdk:21-jdk-alpine
COPY target/space-api.jar space-api.jar
ENTRYPOINT ["java", "-jar", "/space-api.jar"]
