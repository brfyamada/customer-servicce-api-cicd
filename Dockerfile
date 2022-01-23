## [JENKINS] [KUBERNETS] [DOCKERHUB] [STEP 1]
FROM adoptopenjdk/openjdk11:alpine-slim
EXPOSE 8082
RUN mkdir /app
WORKDIR /app
COPY build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]