# Use a base image with JDK
FROM eclipse-temurin:22-jdk-alpine

ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]




