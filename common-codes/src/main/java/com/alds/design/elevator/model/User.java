package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public class User {
	
	private int userId;
	private int weight;
	
	public User(int userId) {
		super();
		this.userId = userId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getUserId() {
		return userId;
	}

}
