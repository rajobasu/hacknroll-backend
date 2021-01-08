package com.example.hacknroll.core.database;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

import com.example.hacknroll.core.RequestDatabase;
import com.example.hacknroll.core.dataitems.Match;
import com.example.hacknroll.core.dataitems.Request;

public class InMemoryRequestDatabase implements RequestDatabase {

	private ConcurrentSkipListSet<Match> matchesSortedByUserID;
	private ConcurrentSkipListSet<Match> matchesSortedByRequestID;
	private ConcurrentSkipListSet<Request> activeRequests;

	@Override
	synchronized public void addRequest(Request request) {
		activeRequests.add(request);
	}

	@Override
	synchronized public void addPairing(Match match) {
		matchesSortedByRequestID.add(match);
		matchesSortedByUserID.add(match);
	}

	@Override
	public SortedSet<Request> searchRequest(String... s) {
		return activeRequests;
	}

	@Override
	synchronized public void removeRequest(long id) {
		activeRequests.ceiling(new Request(id));
	}

	@Override
	synchronized public void removePairing(Match match) {
		matchesSortedByRequestID.remove(match);
		matchesSortedByUserID.remove(match);
	}

	@Override
	public void initDatabase() {

		activeRequests = new ConcurrentSkipListSet<>((x, y) -> (int) Math.signum(x.getID() - y.getID()));
		matchesSortedByRequestID = new ConcurrentSkipListSet<>(
				(x, y) -> (int) Math.signum(x.getUserID() - y.getUserID()));

		matchesSortedByRequestID = new ConcurrentSkipListSet<>(
				(x, y) -> (int) Math.signum(x.getRequestID() - y.getRequestID()));
	}

	@Override
	public List<Match> searchMatchByUserID(long userID) {
		return matchesSortedByUserID.stream().filter(x -> x.getUserID() == userID)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public List<Match> searchMatchByRequestID(long requestID) {

		return matchesSortedByRequestID.stream().filter(x -> x.getRequestID() == requestID)
				.collect(Collectors.toCollection(LinkedList::new));
	}
}
