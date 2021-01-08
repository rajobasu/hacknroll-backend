package com.example.hacknroll.core.dataitems;

public class Entity {
	protected long id;

	Entity(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		return 	obj instanceof Entity && 
				this.getClass().equals(obj.getClass()) && 
				this.id == ((Entity) obj).id;
		
	}
	
	public long getID() {
		return id;
	}
}
