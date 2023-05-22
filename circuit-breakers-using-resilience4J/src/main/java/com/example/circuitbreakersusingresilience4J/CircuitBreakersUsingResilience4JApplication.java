package com.example.circuitbreakersusingresilience4J;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CircuitBreakersUsingResilience4JApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakersUsingResilience4JApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
