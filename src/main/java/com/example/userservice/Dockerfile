FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/project-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8082
