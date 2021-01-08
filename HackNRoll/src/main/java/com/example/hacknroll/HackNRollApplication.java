package com.example.hacknroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication @RestController
public class HackNRollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackNRollApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
}
