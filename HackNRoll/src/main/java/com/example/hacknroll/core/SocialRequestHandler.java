package com.example.hacknroll.core;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hacknroll.core.database.RequestDatabase;
import com.example.hacknroll.core.database.UserDatabase;
import com.example.hacknroll.core.dataitems.Match;
import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

public class SocialRequestHandler {
	private RequestDatabase requestDB;
	private LoginHandler loginHandler;
	private UserDatabase userDB;

	private static SocialRequestHandler instance;

	private SocialRequestHandler(RequestDatabase db, UserDatabase db2) {
		this.requestDB = db;
		this.userDB = db2;
		this.loginHandler = LoginHandler.getInstance();
	}

	public static SocialRequestHandler getInstance() {
		if (instance == null) {
			instance = new SocialRequestHandler(RequestDatabase.getInstance(), UserDatabase.getInstance());
		}
		return instance;
	}

	public void addUser(User user) {
		userDB.addUser(user);
	}

	public Request addRequest(Request request) {
		requestDB.addRequest(request);
		return request;
	}

	public void removeRequest(Request request) {
		removeRequest(request.getID());
	}

	public void removeRequest(long id) {
		requestDB.removeRequest(id);
	}

	public List<Request> search() {
		return requestDB.searchRequest().stream().collect(Collectors.toCollection(LinkedList::new));
	
	}

	public List<Request> search(String category) {
		return requestDB.searchRequest().stream().filter(x -> x.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toCollection(LinkedList::new));

	}

	public void login(String username, String password) {
		this.loginHandler.login(username, password);
	}

	public List<Request> getAllRequestsByUserID(long userid) {
		return this.requestDB.searchRequestsByUserID(userid);
	}

	public List<User> getMatchesByRequestID(long id) {
		return this.requestDB.searchMatchByRequestID(id);
	}

	public List<Request> getMatchesByUserID(long id) {
		return this.requestDB.searchMatchByUserID(id);
	}

	public void match(long requestID, long userID) {
		Request r = requestDB.getRequestByID(requestID);
		User u = userDB.getUserInfo(userID);
		System.out.println(r + "  = : = " + u);
		requestDB.addPairing(new Match(r, u));
		r.match(u);
	}

	public void unmatch(long requestID, long userID) {
		Request r = requestDB.getRequestByID(requestID);
		User u = userDB.getUserInfo(userID);
		requestDB.removePairing(new Match(r, u));
		r.unmatch(u);
	}

}
