package com.example.hacknroll.core.dataitems;

public class User extends Entity {
	private String username;
	private String telegramID;

	public User(String username, String telegramID) {
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
