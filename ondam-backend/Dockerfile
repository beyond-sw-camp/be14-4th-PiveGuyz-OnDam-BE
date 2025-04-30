# 1단계: Build Stage (arm64 호환되는 gradle 이미지 사용)
FROM gradle:7.6.2-jdk17-alpine3.18 AS build
WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
RUN gradle build --no-daemon || return 0

COPY . .
RUN gradle clean build --no-daemon

# 2단계: Run Stage (temurin 대신 arm64 호환 openjdk로 변경)
FROM openjdk:17-alpine
WORKDIR /app

COPY --from=build /app/build/libs /app/build/libs
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
