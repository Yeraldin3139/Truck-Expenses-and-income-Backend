# ===========================
# 1. Build stage (usando Maven)
# ===========================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos solo el pom.xml primero para aprovechar cache
COPY pom.xml .
RUN mvn -q -e -B dependency:go-offline

# Ahora copiamos el código
COPY src ./src

# Construimos el JAR
RUN mvn -q -e -B clean package -DskipTests

# ===========================
# 2. Runtime stage (distroless)
# ===========================
FROM gcr.io/distroless/java17:nonroot

WORKDIR /app

# Copiamos el JAR generado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Usamos el launcher distroless
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
