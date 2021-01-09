package com.example.hacknroll.core.dataitems;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class Request extends Entity {
	private long userID;
	private String title;
	private String description;
	private Instant endTime;
	private List<User> usersMatched;

	public Request(long id) {
		super(id);
	}

	public Request(long userID, String title, String description, Instant endTime) {
		this.userID = userID;
		this.title = title;
		this.description = description;
		this.endTime = endTime;
		this.usersMatched = new LinkedList<>();
	}

	public long getUserID() {
		return userID;
	}

	public long getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Instant getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "RESPONSE : " + title + ":" + description + ":" + endTime + " : " + userID;
	}

	public void match(User user) {
		usersMatched.add(user);
	}

	public void unmatch(User user) {
		usersMatched.remove(user);
	}

	public List<User> getUsersMatched() {
		return usersMatched;
	}
}
