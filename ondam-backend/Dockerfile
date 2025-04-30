FROM gradle:7.6.0-jdk17
WORKDIR /app

# 전체 프로젝트 복사 (application.yml 포함)
COPY . .

# gradlew 실행 권한 부여
RUN chmod +x ./gradlew

# 빌드 (테스트 제외)
RUN ./gradlew clean build -x test --no-daemon

# 실행할 JAR 복사 (가장 마지막 빌드된 파일)
RUN cp build/libs/$(ls build/libs | grep -v plain) app.jar

# 포트 오픈 (Spring 설정 포트와 일치시켜야 함)
EXPOSE 8083

# Spring Boot 실행 + 로그 레벨 조정 + 외부 config 명시
ENTRYPOINT ["java", "-Dlogging.level.root=INFO", "-Dlogging.level.org.springframework=DEBUG", "-jar", "app.jar", "--spring.config.location=classpath:/,file:./application.yml"]
