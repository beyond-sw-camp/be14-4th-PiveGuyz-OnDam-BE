# 빌드 단계
FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app

COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

# 실행 단계
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/app.jar .

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
