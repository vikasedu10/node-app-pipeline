FROM openjdk:11-jre-alpine

EXPOSE 8080

COPY ./target/gs-maven-0.1.0.jar /usr/app
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "gs-maven-0.1.0.jar"]
