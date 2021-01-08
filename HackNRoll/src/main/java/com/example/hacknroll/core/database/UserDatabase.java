package com.example.hacknroll.core.database;

import com.example.hacknroll.core.dataitems.User;

public interface UserDatabase extends Database {
	void addUser(User user);

	void loginUser();

	void logoutUser();

	User getUserInfo();
}
