package com.cs.app.model;

/**
 * @author rohsingh
 *
 */
public class Bucket implements Shape {

	private int x;
	private int y;
	private String fillColor;

	public Bucket(int x, int y, String fillColor) {
		this.x = x;
		this.y = y;
		this.fillColor = fillColor;
	}

	@Override
	public boolean validate() {
		return x >= 0 && y >= 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getFillColor() {
		return fillColor;
	}

}
