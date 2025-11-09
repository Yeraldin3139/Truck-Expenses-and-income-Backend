FROM eclipse-temurin:21-jdk-focal
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN apt-get update && apt-get install -y maven
RUN mvn -f pom.xml -DskipTests package
EXPOSE 8080
CMD ["java","-jar","target/truck-backend-0.0.1-SNAPSHOT.jar"]
