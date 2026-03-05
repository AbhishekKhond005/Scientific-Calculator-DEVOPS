FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/*.jar app.jar

# Run interactively — always start with: docker run -it <image>
CMD ["java", "-jar", "app.jar"]
