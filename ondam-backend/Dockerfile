FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

COPY gradlew ./
RUN chmod +x gradlew

COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

# 🔥 반드시 bootJar
RUN ./gradlew clean bootJar -x test --no-daemon
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/app.jar .

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
