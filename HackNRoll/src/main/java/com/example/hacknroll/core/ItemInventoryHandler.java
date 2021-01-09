package com.example.hacknroll.core;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hacknroll.core.database.ItemDatabase;
import com.example.hacknroll.core.database.UserDatabase;
import com.example.hacknroll.core.dataitems.Item;
import com.example.hacknroll.core.dataitems.User;

public class ItemInventoryHandler {
	private ItemDatabase itemDB;
	private static ItemInventoryHandler INSTANCE;

	private ItemInventoryHandler() {

	}

	public static ItemInventoryHandler getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ItemInventoryHandler();
		return INSTANCE;
	}

	public void addItem(Item item) {
		itemDB.addItem(item);
	}

	synchronized public boolean takeItem(long itemID, long userID) {
		Item item = itemDB.getItemByID(itemID);
		if (item.isTaken()) {
			return false;
		} else {
			item.take(UserDatabase.getInstance().getUserInfo(userID));
		}
		return true;
	}

	public List<Item> search(String... params) {
		return itemDB.search();
	}

	public List<Item> getByUserIDAvailable(long userid) {
		return itemDB.getItemsCreatedBy(userid).stream().filter(x -> x.getAvailable())
				.collect(Collectors.toCollection(LinkedList::new));
	}

	public List<Item> getByUserIDUnAvailable(long userID) {
		return itemDB.getItemsCreatedBy(userID).stream().filter(x -> !x.getAvailable())
				.collect(Collectors.toCollection(LinkedList::new));
	}

	public List<Item> getUnmatched() {
		return search().stream().filter(x -> !x.isTaken()).collect(Collectors.toCollection(LinkedList::new));
	}

	public void unmatch(long itemID) {
		Item item = itemDB.getItemByID(itemID);
		return;
	}
}
