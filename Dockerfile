FROM maven:3.9.9-eclipse-temurin-23 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/dei-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

