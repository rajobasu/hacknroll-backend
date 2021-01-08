package com.example.hacknroll.core;

import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

public class Match {
	private Request request;
	private User user;
	public Match(Request request, User user) {
		super();
		this.request = request;
		this.user = user;
	}
	public Request getRequest() {
		return request;
	}
	public User getUser() {
		return user;
	}
	public long getUserID() {
		return user.getID();
	}
	public long getRequestID() {
		return request.getID();
	}
	
}
