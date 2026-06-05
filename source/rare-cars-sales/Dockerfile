FROM maven:3.9.11-eclipse-temurin-24 AS build

WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests package

FROM eclipse-temurin:24-jre

WORKDIR /app
COPY --from=build /workspace/target/rare-cars-sales-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
