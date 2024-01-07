FROM openjdk:21-ea-1-jdk-oracle
COPY target/client-api-1.0.0.jar /app/client-api-1.0.0.jar
ENTRYPOINT ["java","-jar","/app/client-api-1.0.0.jar"]