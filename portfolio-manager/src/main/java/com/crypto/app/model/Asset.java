/**
 * 
 */
package com.crypto.app.model;

/**
 * @author rohsi
 *
 */
public class Asset {
	
	private String ticker;
	private AssetType assetType;
	private double stockPrice;
	private double strike;
	private double volatility;
	private double interest;
	private double timeHorizon;
	
	public Asset() {
	}

	public Asset(String ticker, AssetType assetType, double stockPrice, double strike, double volatility, double interest,
			double timeHorizon) {
		super();
		this.ticker = ticker;
		this.assetType = assetType;
		this.stockPrice = stockPrice;
		this.strike = strike;
		this.volatility = volatility;
		this.interest = interest;
		this.timeHorizon = timeHorizon;
	}

	public String getTicker() {
		return ticker;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public double getStrike() {
		return strike;
	}

	public double getVolatility() {
		return volatility;
	}

	public double getInterest() {
		return interest;
	}

	public double getTimeHorizon() {
		return timeHorizon;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public void setStrike(double strike) {
		this.strike = strike;
	}

	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void setTimeHorizon(double timeHorizon) {
		this.timeHorizon = timeHorizon;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Asset [ticker=");
		builder.append(ticker);
		builder.append(", assetType=");
		builder.append(assetType);
		builder.append(", strike=");
		builder.append(strike);
		builder.append(", volatility=");
		builder.append(volatility);
		builder.append(", interest=");
		builder.append(interest);
		builder.append(", timeHorizon=");
		builder.append(timeHorizon);
		builder.append("]");
		return builder.toString();
	}

	
	

}
