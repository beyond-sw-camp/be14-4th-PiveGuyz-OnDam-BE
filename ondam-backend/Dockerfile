# 베이스 이미지: JDK 포함된 gradle 공식 이미지 사용 (M1 호환)
FROM gradle:7.6.0-jdk17 AS build

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 캐시 위치 변경 (권한 문제 방지)
ENV GRADLE_USER_HOME=/app/.gradle-cache

# gradle 관련 파일 복사
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# 소스 복사
COPY src ./src

# gradlew 실행 권한 부여
RUN chmod +x gradlew

# 빌드 수행 (테스트 제외, JAR 생성)
RUN ./gradlew clean build -x test --no-daemon

# 실행할 JAR 복사 (plain 제외)
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

# 런타임 포트
EXPOSE 8083

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
