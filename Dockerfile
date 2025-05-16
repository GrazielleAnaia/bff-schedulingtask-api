FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/bff-schedulingtask-api-0.0.1-SNAPSHOT.jar /app/bff-schedulingtask-api.jar

EXPOSE 8184

CMD ["java", "-jar", "/app/bff-schedulingtask-api.jar"]