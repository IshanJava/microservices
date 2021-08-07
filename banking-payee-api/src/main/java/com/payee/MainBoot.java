package com.payee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping("/v10")
public class MainBoot {
	
	@GetMapping("/foo")
	public String foo(@RequestParam String name){
		return "Hello Mr. foo = "+name;
	}
		
	public static void main(String[] args) {
		
		SpringApplication.run(MainBoot.class, args);
	}

}
