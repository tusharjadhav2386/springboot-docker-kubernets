FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springboot-docker-kubernets.jar
ENTRYPOINT ["java","-jar","/springboot-docker-kubernets.jar"]