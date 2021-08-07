package com.payee;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
	
	private static final String BASE_URL="http://banking-api-emp/v2";
	
	//Registered as bean
	@Bean("owowowo")
	@LoadBalanced
	public WebClient getWebClient() {
	      	WebClient webClient=WebClient.create(BASE_URL);
	      	return webClient;
	}

}
