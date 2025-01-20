# Use OpenJDK 17 for the build stage
FROM openjdk:17-alpine AS build

# Install Maven 4.0.0
RUN apk add --no-cache curl && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-4/4.0.0/binaries/apache-maven-4.0.0-bin.tar.gz | tar -xz -C /opt && \
    ln -s /opt/apache-maven-4.0.0/bin/mvn /usr/bin/mvn

# Copy your application source
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use OpenJDK 17 for the runtime stage
FROM openjdk:17-alpine
COPY --from=build /target/*.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
