package com.revolut.moneytransfer.model;

/**
 * 
 * @author rohsingh
 *
 */
public class Account {

	private User user;
	private Long accountId;
	private Double balance;
	private Double blockedAmount;

	public Account(User user, Long accountId, Double balance, Double blockedAmount) {
		super();
		this.user = user;
		this.accountId = accountId;
		this.balance = balance;
		this.blockedAmount = blockedAmount;
	}

	public User getUser() {
		return user;
	}

	public Long getAccountId() {
		return accountId;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getBlockedAmount() {
		return blockedAmount;
	}



}
