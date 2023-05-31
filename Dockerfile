# Stage 1: Build and install the DTO project into local maven repository
FROM maven:3.8.3-openjdk-17 AS builder
WORKDIR /PochemonLib

# Copy your DTO project
COPY ./PochemonLib/pom.xml ./pom.xml
COPY ./PochemonLib/src ./src

# Build the DTO project and install it into the local maven repository
RUN mvn clean install

WORKDIR /CardService

# Copy your main project
COPY ./CardService/pom.xml ./pom.xml
COPY ./CardService/src ./src

# Build the main project with the dependencies
RUN mvn clean package -DskipTests

# Stage 3: Copy the artifact and run
FROM openjdk:17-jdk-slim
WORKDIR /CardService

COPY --from=builder /CardService/target/card-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java","-jar","app.jar"]