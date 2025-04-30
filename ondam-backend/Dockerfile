FROM gradle:7.6.0-jdk17
WORKDIR /app

# 캐시 디렉토리 변경: /app/cache 로 설정 (권한 충돌 방지)
ENV GRADLE_USER_HOME=/app/cache

# 필요한 파일 복사
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

# 빌드 (테스트 제외)
RUN ./gradlew clean build -x test --no-daemon

# 실행할 JAR 추출
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
