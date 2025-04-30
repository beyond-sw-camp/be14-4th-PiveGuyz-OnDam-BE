# 1단계: Build Stage
FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app

# ✅ 캐시 경로를 /app/.gradle 로 명시적으로 변경
ENV GRADLE_USER_HOME=/app/.gradle

COPY build.gradle settings.gradle ./
COPY gradle ./gradle

RUN gradle build --no-daemon || return 0

COPY . .
RUN gradle clean build --no-daemon

# 2단계: Run Stage
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/build/libs /app/build/libs
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
