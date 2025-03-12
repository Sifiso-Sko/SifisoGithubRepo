FROM openjdk:17-jdk-alpine

# Use the ARG to define the JAR file location
ARG JAR_FILE=target/*.jar

# Copy the JAR file into the container
COPY ./target/hello-world-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]
