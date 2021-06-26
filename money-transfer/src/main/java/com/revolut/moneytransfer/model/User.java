package com.revolut.moneytransfer.model;

/**
 * @author rohsingh
 *
 */
public class User {

	private String userId;
	private String name;

	public User(String userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

}
