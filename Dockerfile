FROM maven:3-openjdk-17 AS build-image
WORKDIR /to-build-app
COPY . .
RUN  ./mvn dependency:go-offline
RUN ./mvn clean package


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build-image /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]