FROM maven:3-openjdk-23 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-alpine
COPY --from=build /target/*.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]