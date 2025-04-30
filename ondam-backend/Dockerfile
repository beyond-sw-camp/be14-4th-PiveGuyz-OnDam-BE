# Gradle + JDK17 단일 이미지
FROM gradle:7.6.0-jdk17

# 작업 디렉토리
WORKDIR /app

# Gradle 캐시 디렉토리 권한 방지
ENV GRADLE_USER_HOME=/app/cache

# gradle wrapper 및 설정 복사
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# 리소스만 복사 (최소한의 복사)
COPY src/main/resources/application.yml ./src/main/resources/application.yml
COPY src/main/java ./src/main/java

# gradlew 실행 권한 부여
RUN chmod +x gradlew

# 빌드 (테스트 제외)
RUN ./gradlew clean build -x test --no-daemon

# 실행할 JAR 추출
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

# Spring 실행 포트
EXPOSE 8083

# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]
