package com.example.hacknroll.core;

import java.util.Map;
import java.util.TreeMap;

import com.example.hacknroll.core.database.UserDatabase;
import com.example.hacknroll.core.dataitems.User;

public class LoginHandler {
	private UserDatabase userDB;
	private Map<Long, Long> accessTokens;
	private static long ACCESS_TOKEN_COUNT = 0;
	private static LoginHandler instance;

	private static long generateAccessToken() {
		return ACCESS_TOKEN_COUNT++;
	}

	private LoginHandler() {
		this.userDB = UserDatabase.getInstance();
		accessTokens = new TreeMap<>();
	}

	public AccessToken login(String username, String password) {
		User user = userDB.getUserInfo(username);
		System.out.println("LOGIN ATTEMPT : " + username + " " + password + " " + user);
		if (user == null) {
			return null;
		} else if (user.login(password)) {

			long x = generateAccessToken();
			accessTokens.put(user.getID(), x);
			return new AccessToken(x, user);
		} else {
			return null;
		}
	}

	public void logout(long userID) {
		accessTokens.remove(userID);
	}

	public void signup(User user) {
		userDB.addUser(user);
	}

	public boolean verifyAccessToken(long userID, long accessToken) {
		return accessTokens.get(userID) == accessToken;
	}

	public static LoginHandler getInstance() {
		if (instance == null)
			instance = new LoginHandler();
		return instance;
	}
}
