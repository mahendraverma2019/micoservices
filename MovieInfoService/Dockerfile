FROM openjdk:8-jdk-alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} MovieInfoService-0.0.1.jar
ENTRYPOINT ["java","-jar","/MovieInfoService-0.0.1.jar"]