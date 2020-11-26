FROM openjdk:12-jdk-alpine
VOLUME /tmp
VOLUME /src/main/resources
ADD src/main/resources/city.txt /src/main/resources/city.txt
ADD target/CityConnector-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]