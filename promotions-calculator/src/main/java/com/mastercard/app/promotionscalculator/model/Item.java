package com.mastercard.app.promotionscalculator.model;

public enum Item {

	A(10.0), 
	B(9.0), 
	C(10.0), 
	D(5.0), 
	E(4.0), 
	F(8.0),
	G(3.0),
	H(2.0);

	private double price;

	Item(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

}
