package com.example.hacknroll.core.database;

import java.util.List;

import com.example.hacknroll.core.dataitems.Item;

public abstract class ItemDatabase implements Database {

	private static ItemDatabase INSTANCE;

	protected ItemDatabase() {

	}

	public static ItemDatabase getItemDatabase() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryItemDatabase();
		return INSTANCE;
	}

	abstract public void addItem(Item item);

	abstract public List<Item> getItemsSelectedBy(long userid);

	abstract public Item getItemByID(long itemid);

	abstract public List<Item> getItemsCreatedBy(long id);
}
