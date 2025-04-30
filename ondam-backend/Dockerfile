FROM gradle:7.6.0-jdk17
WORKDIR /app

# Gradle 캐시 경로 변경 (권한 문제 회피)
ENV GRADLE_USER_HOME=/app/cache

# 전체 소스 복사
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

# 반드시 명시적으로 resource도 복사 (안정성↑)
COPY src/main/resources/application.yml ./src/main/resources/

# 실행 권한 부여
RUN chmod +x gradlew

# 빌드 (테스트 제외)
RUN ./gradlew clean build -x test --no-daemon

# 실행용 JAR 추출
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
