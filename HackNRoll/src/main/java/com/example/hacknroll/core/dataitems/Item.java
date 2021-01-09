package com.example.hacknroll.core.dataitems;

import com.example.hacknroll.core.database.UserDatabase;

public class Item extends Entity {
	private String name;
	private String description;
	private User itemCreatedBy;
	private User takenBy;

	public Item(String name, String description, long id) {
		this.name = name;
		this.description = description;
		this.takenBy = null;
		this.itemCreatedBy = UserDatabase.getInstance().getUserInfo(id);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isTaken() {
		return takenBy != null;
	}

	public User getTakenBy() {
		return takenBy;
	}

	public User getItemCreatedBy() {
		return itemCreatedBy;
	}

	public void take(User userInfo) {
		this.takenBy = userInfo;
	}
}
