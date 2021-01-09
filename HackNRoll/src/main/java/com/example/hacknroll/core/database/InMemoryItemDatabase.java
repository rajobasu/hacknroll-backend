package com.example.hacknroll.core.database;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hacknroll.core.dataitems.Item;

public class InMemoryItemDatabase extends ItemDatabase {

	private List<Item> allItems;

	protected InMemoryItemDatabase() {
		initDatabase();
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		allItems.add(item);
	}

	@Override
	public List<Item> getItemsSelectedBy(long userid) {
		// TODO Auto-generated method stub
		return allItems.stream().filter(x -> x.isTaken() && x.getTakenBy().getID() == userid)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Item getItemByID(long itemid) {
		// TODO Auto-generated method stub
		return allItems.stream().filter(x -> x.getID() == itemid).findFirst().get();
	}

	@Override
	public List<Item> getItemsCreatedBy(long id) {
		// TODO Auto-generated method stub
		return allItems.stream().filter(x -> x.getItemCreatedBy().getID() == id)
				.collect(Collectors.toCollection(LinkedList::new));
	}
	
	@Override
	public void initDatabase() {
		allItems = new LinkedList<>();

	}

	@Override
	public List<Item> search(String... params) {
		return allItems;
	}

}
