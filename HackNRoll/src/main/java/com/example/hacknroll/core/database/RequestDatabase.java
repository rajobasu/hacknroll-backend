package com.example.hacknroll.core.database;

import java.util.List;
import java.util.SortedSet;

import com.example.hacknroll.core.dataitems.Match;
import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

public interface RequestDatabase extends Database {
	void addRequest(Request request);

	void addPairing(Match match);

	SortedSet<Request> searchRequest(String... s);

	void removeRequest(long id);

	void removePairing(Match match);

	List<Request> searchMatchByUserID(long userID);

	List<User> searchMatchByRequestID(long requestID);

	List<Request> searchRequestsByUserID(long userID);
}
