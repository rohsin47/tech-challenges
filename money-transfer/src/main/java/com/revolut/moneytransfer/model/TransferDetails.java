package com.revolut.moneytransfer.model;

/**
 * @author rohsingh
 *
 */
public class TransferDetails {

	private Long transferId;
	private Long fromAccountId;
	private Long toAccountId;
	private Double amount;
	private String userId;
	private String status;
	
	public TransferDetails(Long transferId, Long fromAccountId, Long toAccountId, Double amount, String userId,
			String status) {
		super();
		this.transferId = transferId;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.userId = userId;
		this.status = status;
	}

	public Long getTransferId() {
		return transferId;
	}

	public Long getFromAccountId() {
		return fromAccountId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public String getUserId() {
		return userId;
	}

	public String getStatus() {
		return status;
	}

	
	
}
