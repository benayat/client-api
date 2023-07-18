FROM openjdk:17-alpine
COPY target/client-api-0.0.1-SNAPSHOT.jar /app/client-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/client-api-0.0.1-SNAPSHOT.jar"]