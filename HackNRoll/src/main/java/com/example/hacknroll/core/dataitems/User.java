package com.example.hacknroll.core.dataitems;

public class User extends Entity {
	private String username;
	private String telegramID;
	private String password;
	private boolean isLoggedIn;

	public User(String username, String telegramID, String password) {
		this.username = username;
		this.telegramID = telegramID;
		this.password = password;
		this.isLoggedIn = false;
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

	public boolean login(String password) {
		if (isLoggedIn() || validatePassword(password)) {
			isLoggedIn = true;
			return true;
		}
		return false;
	}

	public void logout() {
		isLoggedIn = false;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public boolean validatePassword(String password) {
		return password.equals(this.password);
	}
}
