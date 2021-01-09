package com.example.hacknroll.core.database;

import java.util.List;
import java.util.SortedSet;

import com.example.hacknroll.core.dataitems.Match;
import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

public abstract class RequestDatabase implements Database {
	private static RequestDatabase INSTANCE;

	protected RequestDatabase() {
		initDatabase();
	}

	public static RequestDatabase getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryRequestDatabase();
		return INSTANCE;
	}

	public abstract void addRequest(Request request);

	public abstract void addPairing(Match match);

	public abstract SortedSet<Request> searchRequest(String... s);

	public abstract void removeRequest(long id);

	public abstract void removePairing(Match match);

	public abstract List<Request> searchMatchByUserID(long userID);

	public abstract List<User> searchMatchByRequestID(long requestID);

	public abstract List<Request> searchRequestsByUserID(long userID);

	public abstract Request getRequestByID(long requestID);
}
