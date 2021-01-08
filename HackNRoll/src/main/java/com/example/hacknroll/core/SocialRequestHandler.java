package com.example.hacknroll.core;

import java.util.LinkedList;
import java.util.List;

import com.example.hacknroll.core.database.InMemoryRequestDatabase;
import com.example.hacknroll.core.database.InMemoryUserDatabase;
import com.example.hacknroll.core.database.RequestDatabase;
import com.example.hacknroll.core.database.UserDatabase;
import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

public class SocialRequestHandler {
	private RequestDatabase requestDB;
	private LoginHandler loginHandler;
	private UserDatabase userDB;

	private static SocialRequestHandler instance;

	private SocialRequestHandler(RequestDatabase db, UserDatabase db2) {
		this.requestDB = db;
		this.requestDB.initDatabase();
		this.userDB = db2;
		this.userDB.initDatabase();
		this.loginHandler = LoginHandler.getInstance();
	}

	public static SocialRequestHandler getInstance() {
		if (instance == null) {
			instance = new SocialRequestHandler(new InMemoryRequestDatabase(), UserDatabase.getInstance());
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
		List<Request> get = new LinkedList<>();
		for (var x : requestDB.searchRequest()) {
			get.add(x);
		}
		return get;
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
}
