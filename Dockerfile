FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/GesF-1.0.jar GesF-1.0.jar
ENTRYPOINT ["java","-jar","/GesF-1.0.jar"]
