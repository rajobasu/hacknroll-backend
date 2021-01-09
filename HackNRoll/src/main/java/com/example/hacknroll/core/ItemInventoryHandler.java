package com.example.hacknroll.core;

import com.example.hacknroll.core.database.ItemDatabase;
import com.example.hacknroll.core.database.UserDatabase;
import com.example.hacknroll.core.dataitems.Item;

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
	
	
}
