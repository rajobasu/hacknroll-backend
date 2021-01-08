package com.example.hacknroll.core;

import java.util.LinkedList;
import java.util.List;

import com.example.hacknroll.core.database.InMemoryRequestDatabase;
import com.example.hacknroll.core.database.UserDatabase;
import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

public class SocialRequestHandler {
	private RequestDatabase requestDB;
	private UserDatabase userDB;

	private static SocialRequestHandler instance;

	private SocialRequestHandler(RequestDatabase db, UserDatabase db2) {
		this.requestDB = db;
		this.requestDB.initDatabase();
		this.userDB = db2;
		this.userDB.initDatabase();
	}

	public static SocialRequestHandler getInstance() {
		if (instance == null) {
			instance = new SocialRequestHandler(new InMemoryRequestDatabase(), new UserDatabase() {

				@Override
				public void initDatabase() {
					// TODO Auto-generated method stub

				}

				@Override
				public void logoutUser() {
					// TODO Auto-generated method stub

				}

				@Override
				public void loginUser() {
					// TODO Auto-generated method stub

				}

				@Override
				public User getUserInfo() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void addUser(User user) {
					// TODO Auto-generated method stub

				}
			});
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
}
