package com.example.hacknroll.core.database;

import java.util.Hashtable;
import java.util.Map;

import com.example.hacknroll.core.dataitems.User;

public class InMemoryUserDatabase extends UserDatabase {

	private Map<Long, User> userTable;
	private Map<String, Long> usernameUserIDTable;

	protected InMemoryUserDatabase() {
		initDatabase();
	}

	@Override
	public void initDatabase() {
		userTable = new Hashtable<>();
		usernameUserIDTable = new Hashtable<>();
	}

	@Override
	synchronized public void addUser(User user) {
		System.out.println(user);
		userTable.put(user.getID(), user);
		usernameUserIDTable.put(user.getUsername(), user.getID());
	}

	@Override
	public User getUserInfo(long id) {
		// TODO Auto-generated method stub
		return userTable.get(id);
	}

	@Override
	public User getUserInfo(String id) {
		try {
			return getUserInfo(usernameUserIDTable.get(id));
		} catch(Exception e) {
			return null;
		}
	}

}
