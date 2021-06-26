package com.mastercard.app.promotionscalculator.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CartTest {
	
	@Test
	public void testAddCart() {
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		assertTrue(cart.getOrders().size() == 1);
	}
	
	@Test
	public void testRemoveCart() {
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.removeOrder(Item.A);
		assertTrue(cart.getOrders().size() == 0);
	}

	@Test
	public void testCartPrice() {
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		assertTrue(Double.compare(cart.cartPrice(), 10.0) == 0);
	}

}
