package com.example.hacknroll.core.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

	/**
	 * Add a new request into the database
	 * 
	 * @param title
	 * @param description
	 * @param userID
	 * @return
	 */
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

	/**
	 * Get all the requests made by the given user. They include info about which
	 * users have accepted those requests as well
	 * 
	 * @param userID
	 * @return
	 */
	@RequestMapping(value = "/requestsMade", method = POST)
	@ResponseBody
	public List<Request> getRequestsByUser(@RequestParam("user_id") long userID) {

		var x = SocialRequestHandler.getInstance().getAllRequestsByUserID(userID);

		return x;
	}

	/**
	 * include info about which users have accepted those requests
	 * 
	 * @param requestID
	 * @return
	 */
	@RequestMapping(value = "/matchedusers", method = POST)
	@ResponseBody
	public List<User> getUsersByRequestID(@RequestParam("request_id") long requestID) {
		return SocialRequestHandler.getInstance().getMatchesByRequestID(requestID);
	}

	/**
	 * Match an item and a user
	 * 
	 * @param requestID
	 * @param userID
	 * @return
	 */
	@RequestMapping(value = "/match", method = POST)
	@ResponseBody
	public boolean match(@RequestParam("request_id") long requestID, @RequestParam("user_id") long userID) {
		SocialRequestHandler.getInstance().match(requestID, userID);
		return true;
	}

	/**
	 * Get all requests accepted by the current user
	 * 
	 * @param userID
	 * @return
	 */
	@RequestMapping(value = "/matchedrequests", method = POST)
	@ResponseBody
	public List<Request> allMatchedItems(@RequestParam("user_id") long userID) {
		return SocialRequestHandler.getInstance().getMatchesByUserID(userID);
	}

	/**
	 * remove a request
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public String removeRequest(long id) {
		return "";
	}

	@RequestMapping(value = "/search", method = POST)
	@ResponseBody
	public List<Request> search(@RequestParam("user_id") long userID) {
		var y = SocialRequestHandler.getInstance().search().stream().filter(x -> x.getUserID() != userID)
				.collect(Collectors.toCollection(LinkedList::new));
		return y;
	}
}
