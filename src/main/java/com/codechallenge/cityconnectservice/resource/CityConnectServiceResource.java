package com.codechallenge.cityconnectservice.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codechallenge.cityconnectservice.model.CityConnectorBean;
import com.codechallenge.cityconnectservice.model.CityConnectorBean.User;
import com.codechallenge.cityconnectservice.config.Config;

@RestController
@RequestMapping("/connected")
public class CityConnectServiceResource {
	
	@Autowired
	private CityConnectorBean cityConnectServiceBean;
	
	@Autowired
    Config config;
	
	/**
	 * This method takes in a Source City and Destination City as input
	 * and returns if a route exists based on the city.txt file
	 * It takes the following input in browser
	 * http://localhost:8081/connected/origin/Boston/destination/Philadelphia
	 * 
	 * @param sourceCity
	 * @param destinationCity
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/origin/{sourceCity}/destination/{destinationCity}")
	public User getResponse(@PathVariable final String sourceCity,
			@PathVariable final String	destinationCity) throws Exception {
		return cityConnectServiceBean.fetchCityConnectorRoutes(sourceCity, destinationCity);
	}
	
	@GetMapping("/{hello}")
	public String getResponseFromMicro(@PathVariable("hello") final String userName) {
		System.out.println("updated call...");
		ResponseEntity<String> response = config.restTemplate().exchange("http://fetch-service/"+userName, 
        		HttpMethod.GET,
                null, new ParameterizedTypeReference<String>() {
                });
		return response.getBody();
	}
}
