package com.mastercard.app.promotionscalculator.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.mastercard.app.promotionscalculator.model.Cart;
import com.mastercard.app.promotionscalculator.model.Item;
import com.mastercard.app.promotionscalculator.promotions.Promotion;

public class CartServiceTest {
	
	@Test
	public void testPromotions() {
		CartService service = new CartService();
		List<Promotion> promos = service.getPromotions();
		assertTrue(promos.size() == 2);
	}
	
	@Test
	public void testCalculateFinalPriceOnEmptyCart() {
		CartService service = new CartService();
		double result = service.calculateFinalPrice(new Cart());
		assertTrue(Double.compare(result, 0.0) == 0);
	}
	
	@Test
	public void testCalculateFinalPriceOnCartWithItems() {
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.B);
		cart.addOrder(Item.B);
		CartService cartService = new CartService();
		double result = cartService.calculateFinalPrice(cart);
		assertTrue(Double.compare(result, 23.5) == 0);
	}

}
