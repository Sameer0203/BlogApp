# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17.0.1-jdk-slim

# Copy the application jar from the build stage
COPY --from=build /target/testSpringProj-0.0.1-SNAPSHOT.jar demo.jar

# Copy the images directory into the container
COPY images images

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "demo.jar"]
