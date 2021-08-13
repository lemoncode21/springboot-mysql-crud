# Docker Build Stage
FROM maven:3-jdk-8-alpine AS build

# Build Stage
WORKDIR /app
COPY ./ /app
RUN mvn clean install

# Docker Build Stage
FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/*.jar app.jar

ENV PORT 5000
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Dserver.port=${PORT}","app.jar"]
