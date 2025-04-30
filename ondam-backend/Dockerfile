# 빌드 환경 설정 (JDK 포함)
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# gradle wrapper의 필요한 파일 먼저 복사
COPY gradlew ./
RUN chmod +x gradlew

COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

# 캐시를 활용해 의존성 다운받기 + 빌드 (테스트는 제외)
RUN ./gradlew build -x test --no-daemon

# 실행에 필요한 JAR 추출
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

# 런타임 환경 (JRE만 포함하여 가볍게 실행)
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/app.jar .

# 포트 노출 (Spring Boot의 application.yml 내 포트와 일치해야 함)
EXPOSE 8083

# 애플리케이션 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]
