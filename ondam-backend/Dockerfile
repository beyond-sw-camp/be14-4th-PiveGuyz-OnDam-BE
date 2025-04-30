# ✅ 1단계: Build Stage (arm64 호환 확인된 Gradle 이미지)
FROM gradle:7.6.0-jdk17-alpine AS build
WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
RUN gradle build --no-daemon || return 0

COPY . .
RUN gradle clean build --no-daemon

# ✅ 2단계: Run Stage (arm64 호환 확인된 JDK 이미지)
FROM eclipse-temurin:17-jdk AS runtime
WORKDIR /app

COPY --from=build /app/build/libs /app/build/libs
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
