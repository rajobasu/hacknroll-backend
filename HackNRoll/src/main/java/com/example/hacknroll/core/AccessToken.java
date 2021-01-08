package com.example.hacknroll.core;

import com.example.hacknroll.core.dataitems.User;

public class AccessToken {
	private long token;
	private User user;

	public AccessToken(long token, User user) {
		super();
		this.token = token;
		this.user = user;
	}

	public long getToken() {
		return token;
	}

	public User getUser() {
		return user;
	}

}
