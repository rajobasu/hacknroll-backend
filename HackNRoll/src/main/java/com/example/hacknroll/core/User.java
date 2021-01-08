package com.example.hacknroll.core;

public class User {
	private String username;
	private long userID;
	private String telegramID;
	private static long USER_ID_COUNT = 0;
	
	
	public User(String username, String telegramID) {
		super();
		this.username = username;
		this.telegramID = telegramID;
		this.userID = USER_ID_COUNT++;
	}


	public String getUsername() {
		return username;
	}


	public long getUserID() {
		return userID;
	}


	public String getTelegramID() {
		return telegramID;
	}
}
