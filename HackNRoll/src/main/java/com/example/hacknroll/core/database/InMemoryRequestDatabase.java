package com.example.hacknroll.core.database;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

import com.example.hacknroll.core.dataitems.Match;
import com.example.hacknroll.core.dataitems.Request;
import com.example.hacknroll.core.dataitems.User;

public class InMemoryRequestDatabase extends RequestDatabase {

	private ConcurrentSkipListSet<Match> matchesSortedByUserID;
	private ConcurrentSkipListSet<Match> matchesSortedByRequestID;

	private ConcurrentSkipListSet<Request> activeRequests;

	private Map<Long, Request> map;

	@Override
	synchronized public void addRequest(Request request) {
		activeRequests.add(request);
		map.put(request.getID(), request);
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
		Request r = activeRequests.ceiling(new Request(id));
		activeRequests.remove(r);
		for (var x : r.getUsersMatched()) {
			removePairing(new Match(r, x));
		}
		map.remove(r.getID());
	}

	@Override
	synchronized public void removePairing(Match match) {
		matchesSortedByRequestID.remove(match);
		matchesSortedByUserID.remove(match);
	}

	@Override
	public void initDatabase() {

		activeRequests = new ConcurrentSkipListSet<>((x, y) -> (int) Math.signum(x.getID() - y.getID()));
		matchesSortedByUserID = new ConcurrentSkipListSet<>((x, y) -> (int) Math.signum(x.getUserID() - y.getUserID()));

		matchesSortedByRequestID = new ConcurrentSkipListSet<>(
				(x, y) -> (int) Math.signum(x.getRequestID() - y.getRequestID()));
		map = new Hashtable<>();
	}

	@Override
	public List<Request> searchMatchByUserID(long userID) {
		return matchesSortedByUserID.stream().filter(x -> x.getUserID() == userID).map(x -> map.get(x.getRequestID()))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public List<User> searchMatchByRequestID(long requestID) {

		return matchesSortedByRequestID.stream().filter(x -> x.getRequestID() == requestID)
				.map(x -> UserDatabase.getInstance().getUserInfo(x.getUserID()))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public List<Request> searchRequestsByUserID(long userID) {
		return activeRequests.stream().filter(x -> x.getUserID() == userID)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Request getRequestByID(long requestID) {
		return map.get(requestID);
	}

}
