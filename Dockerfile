FROM openjdk:1.8-jre

COPY /target/*.jar /usr/share/app.jar
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]
