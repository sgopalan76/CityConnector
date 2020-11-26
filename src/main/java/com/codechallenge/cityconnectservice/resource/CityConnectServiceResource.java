package com.codechallenge.cityconnectservice.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codechallenge.cityconnectservice.model.CityConnectorBean;

@RestController
@RequestMapping("/connected")
public class CityConnectServiceResource {
	
	@Autowired
	private CityConnectorBean cityConnectServiceBean;
	
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
	public String getResponse(@PathVariable final String sourceCity,
			@PathVariable final String	destinationCity) throws Exception {
		return cityConnectServiceBean.fetchCityConnectorRoutes(sourceCity, destinationCity);
	}
	
	@GetMapping("/hello")
	public String getResponseFromDocker() {
		return "Hello Docker";
	}
}
