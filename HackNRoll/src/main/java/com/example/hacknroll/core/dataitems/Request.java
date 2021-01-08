package com.example.hacknroll.core.dataitems;

import java.time.Instant;

public class Request extends Entity {
	private long userID;
	private String title;
	private String description;
	private Instant endTime;

	public Request(long id) {
		super(id);
	}

	public Request(long userID, String title, String description, Instant endTime) {
		this.userID = userID;
		this.title = title;
		this.description = description;
		this.endTime = endTime;
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
}
