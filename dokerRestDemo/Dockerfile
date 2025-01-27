FROM openjdk:21-jdk
ARG JAR_FILE=target/*.jar 
COPY ./target/dokerRestDemo-0.0.1-SNAPSHOT.jar firstImage.jar
ENTRYPOINT ["java","-jar","/firstImage.jar"]