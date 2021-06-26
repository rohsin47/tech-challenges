package com.thoughtworks.cleaner.model;

/**
 * @author rohsi
 *
 */
public class Room {
	
	private Coordinate initialBoundary = new Coordinate(0, 0);
	private Coordinate upperBoundary;
	
	public Room(Coordinate input) {
		this.upperBoundary = input;
	}

	public Coordinate getUpperBoundary() {
		return upperBoundary;
	}

	public void setUpperBoundary(Coordinate upperBoundary) {
		this.upperBoundary = upperBoundary;
	}

}
