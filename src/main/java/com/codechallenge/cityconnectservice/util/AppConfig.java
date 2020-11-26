package com.codechallenge.cityconnectservice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codechallenge.cityconnectservice.model.CityConnectorBean;

@Configuration
public class AppConfig {
	
	/**
	 * 
	 * @return
	 */
	public static CityConnectorBean returnCityConnectorBean() {
		return new CityConnectorBean();
	}

}
