FROM openjdk:17-alpine
COPY target/client-api-1.0.0.jar /app/client-api-1.0.0.jar
ENTRYPOINT ["java","-jar","/app/client-api-1.0.0.jar"]