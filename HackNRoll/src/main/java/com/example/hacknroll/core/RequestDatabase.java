package com.example.hacknroll.core;

import java.util.List;

public interface RequestDatabase {
	void addRequest();
	void addPairing(Match match);
	List<Request> searchRequest(String s);
	void removeRequest(long id);
	void removePairing(Match match);
}
