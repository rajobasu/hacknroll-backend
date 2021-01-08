package com.example.hacknroll.core;

import java.util.List;
import java.util.SortedSet;

import com.example.hacknroll.core.dataitems.Request;

public interface RequestDatabase {
	void initDatabase();
	void addRequest(Request request);
	void addPairing(Match match);
	SortedSet<Request> searchRequest(String... s);
	void removeRequest(long id);
	void removePairing(Match match);
	List<Match> searchMatchByUserID(long userID);
	List<Match> searchMatchByRequestID(long requestID);
}
