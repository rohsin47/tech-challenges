/**
 * 
 */
package com.thoughtworks.cleaner.model;

/**
 * @author rohsi
 *
 */
public class Coordinate {
	
	private int x;
	
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinate newCoordinate(int x, int y) {
		return new Coordinate(this.x + x, this.y + y);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	

}
