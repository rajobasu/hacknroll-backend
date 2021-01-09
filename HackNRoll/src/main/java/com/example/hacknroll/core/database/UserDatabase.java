package com.example.hacknroll.core.database;

import com.example.hacknroll.core.dataitems.User;

public abstract class UserDatabase implements Database {

	private static UserDatabase INSTANCE;

	protected UserDatabase() {

	}

	public abstract void addUser(User user);

	public abstract User getUserInfo(long id);

	public abstract User getUserInfo(String id);

	public static UserDatabase getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryUserDatabase();

		return INSTANCE;
	}
}
