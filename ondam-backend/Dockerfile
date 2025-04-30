# 1단계: Build Stage (ARM64 지원 gradle)
FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
RUN gradle build --no-daemon || return 0

COPY . .
RUN gradle clean build --no-daemon

# 2단계: Run Stage (ARM64 정식 지원 Temurin)
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/build/libs /app/build/libs
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
