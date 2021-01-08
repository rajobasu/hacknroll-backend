package com.example.hacknroll.core.dataitems;

public class Match extends Entity {
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
