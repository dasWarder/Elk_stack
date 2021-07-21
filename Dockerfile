FROM blueapple/openjdk11-alpine

ARG FILE_NAME=target/*.jar

COPY $FILE_NAME /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]