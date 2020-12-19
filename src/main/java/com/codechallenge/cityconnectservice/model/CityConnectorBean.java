package com.codechallenge.cityconnectservice.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.codechallenge.cityconnectservice.config.Config;
import com.codechallenge.cityconnectservice.util.Constants;

@Configuration
@Qualifier("cityConnBean")
@org.springframework.context.annotation.ComponentScan(basePackages="com.codechallenge.cityconnectservice.model")
public class CityConnectorBean {
	
	@Autowired
	User userBean;
	
	@Autowired
    Config config;
	
	/**
	 * 
	 * @param sourceCity
	 * @param destinationCity
	 * @return
	 * @throws IOException
	 */
	public User fetchCityConnectorRoutes(final String sourceCity,
			final String	destinationCity) throws IOException {

		List<String> list = new ArrayList<>();
		String hasRoutes="no";
		String filePath = Constants.filePath;
		String read=sourceCity.concat(Constants.lineSeparator).concat(destinationCity);
		System.out.println(Paths.get(filePath).toAbsolutePath());
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			list = stream
					.filter(line -> line.equalsIgnoreCase(read))
					.map(String::toUpperCase)
					.collect(Collectors.toList());
		} catch(IOException e) {
			e.printStackTrace();
		}
		list.forEach(System.out::println);
		if(list.contains(read.toUpperCase()))
			hasRoutes="yes";
		else 
			hasRoutes="no";
		
		/*ResponseEntity<String> response = config.restTemplate().exchange("http://fetch-service/Venki", 
        		HttpMethod.GET,
                null, new ParameterizedTypeReference<String>() {
                });*/
		
		userBean.setOriginCity(sourceCity);
		userBean.setDestinationCity(destinationCity);
		userBean.setHasCityConnector(hasRoutes);
		//userBean.setMicroserviceCommunicate(response.getBody());
        return userBean;    
        		
    }
	
	@Component
	public class User {
		public String originCity;

		public String destinationCity;
		
		public String hasCityConnector;
		
		public String microserviceCommunicate;

		
		private String getMicroserviceCommunicate() {
			return microserviceCommunicate;
		}

		private void setMicroserviceCommunicate(String microserviceCommunicate) {
			this.microserviceCommunicate = microserviceCommunicate;
		}

		public String getOriginCity() {
			return originCity;
		}

		public void setOriginCity(String originCity) {
			this.originCity = originCity;
		}

		public String getDestinationCity() {
			return destinationCity;
		}

		public void setDestinationCity(String destinationCity) {
			this.destinationCity = destinationCity;
		}

		public String isHasCityConnector() {
			return hasCityConnector;
		}

		public void setHasCityConnector(String hasCityConnector) {
			this.hasCityConnector = hasCityConnector;
		}
	}

}
