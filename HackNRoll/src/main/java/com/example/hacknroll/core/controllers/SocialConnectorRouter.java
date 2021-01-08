package com.example.hacknroll.core.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.Instant;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hacknroll.core.SocialRequestHandler;
import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

@RestController
@RequestMapping("/social")
@CrossOrigin(origins = "http://localhost:3000")
public class SocialConnectorRouter {

	@RequestMapping(value = "/helloworld", method = GET)
	@ResponseBody
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/add", method = POST)
	@ResponseBody
	public Request addNewRequest(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("user_id") long userID) {

		Request toAdd = new Request(userID, title, description, Instant.now().plusSeconds(84094802));
		
		try {
			return SocialRequestHandler.getInstance().addRequest(toAdd);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(value = "/requestsMade", method = POST)
	@ResponseBody
	public List<Request> getRequestsByUser(@RequestParam("user_id") long userID) {

		var x = SocialRequestHandler.getInstance().getAllRequestsByUserID(userID);
		System.out.println(x);
		return x;
	}
	

	@RequestMapping(value = "/matchesrequest", method = POST)
	@ResponseBody
	public List<User> getUsersByRequestID(@RequestParam("request_id") long requestID) {

		return SocialRequestHandler.getInstance().getMatchesByRequestID(requestID);
	}
	

	@RequestMapping("/remove")
	@ResponseBody
	public String removeRequest(long id) {
		return "";
	}

	@RequestMapping("/search")
	@ResponseBody
	public List<Request> search() {
		return SocialRequestHandler.getInstance().search();
	}
}
