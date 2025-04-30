# 베이스 이미지 설정 (JDK 17 포함 Gradle 이미지)
FROM gradle:7.6.0-jdk17
WORKDIR /app

# Gradle 캐시 디렉토리 경로 지정 (권한 문제 방지용)
ENV GRADLE_USER_HOME=/app/.gradle-cache

# Gradle Wrapper 관련 파일 복사
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# 실행 권한 부여
RUN chmod +x gradlew

# 전체 프로젝트 복사 (application.yml 포함)
COPY src ./src

# 빌드 실행 (테스트 제외)
RUN ./gradlew build -x test --no-daemon

# plain이 아닌 JAR 복사
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

# 앱 실행 포트 설정
EXPOSE 8083

# 앱 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
