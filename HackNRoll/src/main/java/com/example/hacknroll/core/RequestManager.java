package com.example.hacknroll.core;

import java.util.LinkedList;
import java.util.List;

import com.example.hacknroll.core.dataitems.Request;

public class RequestManager {
	private RequestDatabase db;

	private static RequestManager instance;

	private RequestManager(RequestDatabase db) {
		this.db = db;
		this.db.initDatabase();
	}

	public static RequestManager getInstance() {
		if (instance == null) {
			instance = new RequestManager(new InMemoryRequestDatabase());
		}
		return instance;
	}

	public Request addRequest(Request request) {
		db.addRequest(request);
		return request;
	}

	public void removeRequest(Request request) {
		removeRequest(request.getID());
	}

	public void removeRequest(long id) {
		db.removeRequest(id);
	}

	public List<Request> search() {
		List<Request> get = new LinkedList<>();
		for(var x : db.searchRequest()) {
			get.add(x);
		}
		return get;
	}
}
