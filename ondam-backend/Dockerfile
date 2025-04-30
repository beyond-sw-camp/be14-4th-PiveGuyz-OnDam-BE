FROM gradle:7.6.0-jdk17
WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test --no-daemon
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-Dlogging.level.root=INFO", "-Dlogging.level.org.springframework=DEBUG", "-jar", "app.jar"]
