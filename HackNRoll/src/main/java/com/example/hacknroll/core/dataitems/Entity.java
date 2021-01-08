package com.example.hacknroll.core.dataitems;

public class Entity {
	private static long ID_COUNT = 0;
	protected long id;

	Entity() {
		this.id = ID_COUNT++;
	}

	Entity(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Entity && this.getClass().equals(obj.getClass()) && this.id == ((Entity) obj).id;

	}

	public long getID() {
		return id;
	}
}
