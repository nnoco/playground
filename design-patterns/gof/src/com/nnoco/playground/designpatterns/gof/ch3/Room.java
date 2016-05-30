package com.nnoco.playground.designpatterns.gof.ch3;

public abstract class Room implements MapSite{
	private int roomNumber;

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public abstract MapSite getSide(Direction direction);
	
	public abstract void setSide(Direction direction, MapSite mapSite);
	
}
