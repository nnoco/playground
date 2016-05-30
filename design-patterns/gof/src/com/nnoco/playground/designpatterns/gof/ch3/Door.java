package com.nnoco.playground.designpatterns.gof.ch3;

public abstract class Door implements MapSite {
	private Room room1;
	private Room room2;
	private boolean isOpen;

	public Door(Room room1, Room room2) {
		this.room1 = room1;
		this.room2 = room2;
	}
	
	public abstract Room otherSideFrom(Room room);
}
