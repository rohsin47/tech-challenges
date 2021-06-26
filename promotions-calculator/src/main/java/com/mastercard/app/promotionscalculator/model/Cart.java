package com.mastercard.app.promotionscalculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

	private final List<Item> itemOrders;
	
	public Cart() {
		this.itemOrders = new ArrayList<>();
	}
	
	public List<Item> getOrders() {
		return Collections.unmodifiableList(this.itemOrders);
	}
	
	public void addOrder(Item order) {
		this.itemOrders.add(order);
	}
	
	public void removeOrder(Item order) {
		this.itemOrders.remove(order);
	}
	
	public Double cartPrice() {
		return this.itemOrders.stream().mapToDouble(Item::getPrice).sum();
	}
	
	@Override
	public String toString() {
		return "Cart [itemOrders=" + itemOrders + "]";
	}
}
