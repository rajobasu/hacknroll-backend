package com.example.hacknroll.core.dataitems;

import java.time.Instant;

public class Request extends Entity{
	private long userID;
	private String title;
	private String description;
	private Instant endTime;

	private static long REQUEST_ID_COUNT = 0;

	public Request(long dummyID) {
		super(dummyID);
	}
	
	public Request(long userID, String title, String description, Instant endTime) {
		super(REQUEST_ID_COUNT++);
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
