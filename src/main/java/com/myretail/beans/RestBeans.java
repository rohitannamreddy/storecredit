package com.myretail.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestBeans {

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
}
