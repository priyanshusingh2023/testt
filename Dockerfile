FROM openjdk:11

ADD ./target/health-monitoring.jar /usr/src/health-monitoring.jar

WORKDIR usr/src
EXPOSE 8080
ENTRYPOINT ["java","-jar", "health-monitoring.jar"]
