package com.example.hacknroll.core;

import java.time.Instant;

public class Request {
	private long userID;
	private long requestID;
	private String title;
	private String description;
	private Instant endTime;

	private static long REQUEST_ID_COUNT = 0;

	public Request(long userID, String title, String description, Instant endTime) {
		super();
		this.userID = userID;
		this.requestID = REQUEST_ID_COUNT++;
		this.title = title;
		this.description = description;
		this.endTime = endTime;
	}

	public long getUserID() {
		return userID;
	}

	public long getRequestID() {
		return requestID;
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
