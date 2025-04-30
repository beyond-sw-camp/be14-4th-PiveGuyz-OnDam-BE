FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

RUN chmod +x gradlew
RUN ./gradlew clean build -x test --no-daemon

RUN cp build/libs/*.jar app.jar

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/app.jar .
COPY src/main/resources/application.yml ./application.yml

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
