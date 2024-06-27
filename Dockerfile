FROM openjdk:11


# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} CPConfigurationService.jar

EXPOSE 9892
ENTRYPOINT ["java","-jar","/CPConfigurationService.jar"]