Requirements
For building and running the application you need:

Enhancement - Deployed on Kubernetes
URL - http://35.185.12.126:8081/connected/origin/san%20diego/destination/los%20angeles

Implemented with Spring security (test/test)

Swagger URL -
http://35.185.12.126:8081/swagger-ui.html#/

JDK 1.11
Maven 4.0
Running the application locally
There are several ways to run a Spring Boot application on your local machine. 
One way is to execute the main method in the com.codechallenge.cityconnectservice.resource.CityConnectServiceResource class 
from your IDE.

Alternatively you can use the Spring Boot from eclipse as a Spring Boot App

The package contains following classes:
RestController class - com.codechallenge.cityconnectservice.resource.CityConnectServiceResource.java
Spring Boot Application class - com.codechallenge.cityconnectservice.CityConnectorApplication.java
Util class - com.codechallenge.cityconnectservice.util.Constants.java
text file - city.txt (to store all connecting cities having roads)
application.properties (contains the spring boot app name and server port)
