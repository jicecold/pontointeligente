FROM openjdk:11.0-jre-slim

COPY ./build/libs/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]