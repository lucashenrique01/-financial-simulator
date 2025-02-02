# Build stage with maven, that's generates our jar
FROM maven:3.8.5-jdk-11 AS Build
ADD . /financial-simulator
WORKDIR /financial-simulator
RUN mvn clean package spring-boot:repackage

# Start with a base image containing Java runtime
FROM openjdk:11

# Make port 8080 available to the world outside this container
EXPOSE 8080

COPY --from=build /financial-simulator/target/insurance-0.0.1-SNAPSHOT.jar financial-simulator.jar


# Run the jar file
ENTRYPOINT ["java","-jar","financial-simulator.jar"]