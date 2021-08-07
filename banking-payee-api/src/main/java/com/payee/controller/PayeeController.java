package com.payee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/v10")
@CrossOrigin(origins = "*") //this can be acceed by other domain
public class PayeeController {
	
	@Autowired
	private WebClient webClient;
	

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/employees/names")
	public List<String> findNames() {
		
		List<String> names=new ArrayList<String>();
		names.add("Jhon");
		names.add("Kumar");
		//Code to access to other API using Eureka server in between
		//HttpClient Code we need
		//RestTemplate
		//WebClient
		int eid=100;
	//	WebClient webClient=WebClient.create("http://desktop-1ql5qv6:9099/v2");
		//http://banking-api-emp/v2/employees/100
		/* EmployeeVO employeeVO=webClient.get().uri("/employees/"+eid)
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		 .retrieve().bodyToMono(EmployeeVO.class).block();*/
		//RestTemplate restTemplate=new RestTemplate();
		
		EmployeeVO employeeVO = //GET
				this.restTemplate.getForObject("http://banking-api-emp/v2/employees/900",EmployeeVO.class);
		System.out.println(")@(@(@(");	
		names.add(employeeVO.getName());
		names.add(employeeVO.getEmail());
		return names;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
