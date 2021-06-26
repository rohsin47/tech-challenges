package com.crypto.app.model;

import java.time.LocalDate;

/**
 * @author rohsi
 *
 */
public class StockQuote {
	
	private String ticker;
    private Double price;
    private LocalDate pricingDate;

    public StockQuote(String ticker, Double price, LocalDate pricingDate) {
        this.ticker = ticker;
        this.price = price;
        this.pricingDate = pricingDate;
    }

    public String getTicker() {
        return ticker;
    }

    public StockQuote setTicker(String quote) {
        this.ticker = quote;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public StockQuote setPrice(Double price) {
        this.price = price;
        return this;
    }

	public LocalDate getPricingDate() {
		return pricingDate;
	}

	public void setPricingDate(LocalDate pricingDate) {
		this.pricingDate = pricingDate;
	}

}
