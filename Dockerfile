FROM eclipse-temurin:8-jre
VOLUME /tmp
ARG JAR_FILE=order-core/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
