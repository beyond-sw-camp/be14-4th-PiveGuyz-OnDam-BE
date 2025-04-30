FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app

COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

# ✅ application.yml도 별도 복사해서 런타임에 JAR 옆에 놓기
COPY src/main/resources/application.yml ./application.yml

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/app.jar .
COPY --from=build /app/application.yml .

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=classpath:/,file:./application.yml"]
