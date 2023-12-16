FROM openjdk:17

COPY target/*.jar /tmp/app.jar
WORKDIR /tmp

CMD ["java", "-jar", "/tmp/app.jar"]