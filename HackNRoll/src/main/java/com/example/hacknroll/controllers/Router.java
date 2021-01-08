package com.example.hacknroll.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Router {
	@RequestMapping("/social/helloworld")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/social/add")
	public String addNewRequest() {
		return "Came to Add Request";
	}
	
	@RequestMapping("/social/remove")
	public String removeRequest(long id) {
		return "";
	}
	
	@RequestMapping("/social/search")
	public String search(long id) {
		return "";
	}
}
