package com.example.hacknroll.core;

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
	
	
	
}
