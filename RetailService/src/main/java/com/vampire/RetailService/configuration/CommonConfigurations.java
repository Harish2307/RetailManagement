package com.vampire.RetailService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfigurations {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
