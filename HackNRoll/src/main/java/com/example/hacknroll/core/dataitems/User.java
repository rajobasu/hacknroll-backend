package com.example.hacknroll.core.dataitems;

public class User extends Entity{
	private String username;
	private String telegramID;
	private static long USER_ID_COUNT = 0;
	
	
	public User(String username, String telegramID) {
		super(USER_ID_COUNT++);
		this.username = username;
		this.telegramID = telegramID;
	}


	public String getUsername() {
		return username;
	}


	public long getUserID() {
		return id;
	}


	public String getTelegramID() {
		return telegramID;
	}
}
