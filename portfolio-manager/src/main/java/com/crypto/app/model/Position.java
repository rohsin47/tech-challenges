package com.crypto.app.model;

/**
 * @author rohsi
 *
 */
public class Position {

	private String asset;
	private double openPrice;
	private int shares ;
	private String currency;
	private String posType;
	
	public Position(String asset, double openPrice, int shares, String currency, String posType) {
		super();
		this.asset = asset;
		this.openPrice = openPrice;
		this.shares = shares;
		this.currency = currency;
		this.posType = posType;
	}

	public String getAsset() {
		return asset;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public int getShares() {
		return shares;
	}

	public String getCurrency() {
		return currency;
	}

	public String getPosType() {
		return posType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Position [asset=");
		builder.append(asset);
		builder.append(", openPrices=");
		builder.append(openPrice);
		builder.append(", shares=");
		builder.append(shares);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", posType=");
		builder.append(posType);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
