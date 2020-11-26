package com.codechallenge.cityconnectservice.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;


import com.codechallenge.cityconnectservice.util.Constants;

@Configuration
@Qualifier("cityConnBean")
@org.springframework.context.annotation.ComponentScan(basePackages="com.codechallenge.cityconnectservice.model")
public class CityConnectorBean {
	
	/**
	 * 
	 * @param sourceCity
	 * @param destinationCity
	 * @return
	 * @throws IOException
	 */
	public String fetchCityConnectorRoutes(final String sourceCity,
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
        return hasRoutes;    
        		
    }

}
