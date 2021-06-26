package com.mastercard.app.promotionscalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mastercard.app.promotionscalculator.model.Cart;
import com.mastercard.app.promotionscalculator.model.Item;
import com.mastercard.app.promotionscalculator.service.CartService;

public class PromotionsCalculatorTest {
	
	@Test
	public void testBuyOneAndGetOtherAtHalfPromotion() {
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.B);
		cart.addOrder(Item.B);
		CartService cartService = new CartService();
		double finalPrice = cartService.calculateFinalPrice(cart);
		assertEquals(23.5, finalPrice, 0.0);
	}
	
	@Test
	public void testBuyOneAndGetOtherAtHalfPromotion2() {
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.A);
		cart.addOrder(Item.B);
		CartService cartService = new CartService();
		double finalPrice = cartService.calculateFinalPrice(cart);
		assertEquals(24.5, finalPrice, 0.0);
	}
	
	@Test
	public void testBuyOneAndGetOtherAtHalfPromotion3() {
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.A);
		CartService cartService = new CartService();
		double finalPrice = cartService.calculateFinalPrice(cart);
		assertEquals(20.0, finalPrice, 0.0);
	}
	
	@Test
	public void testBuyAnyThreeAndGetCheapestOneFreePromotion() {
		Cart cart = new Cart();
		cart.addOrder(Item.C);
		cart.addOrder(Item.D);
		cart.addOrder(Item.E);
		cart.addOrder(Item.H);
		CartService cartService = new CartService();
		double finalPrice = cartService.calculateFinalPrice(cart);
		assertEquals(17.0, finalPrice, 0.0);
	}
	
	@Test
	public void testBuyAnyThreeAndGetCheapestOneFreePromotion2() {
		Cart cart = new Cart();
		cart.addOrder(Item.C);
		cart.addOrder(Item.D);
		cart.addOrder(Item.H);
		CartService cartService = new CartService();
		double finalPrice = cartService.calculateFinalPrice(cart);
		assertEquals(17.0, finalPrice, 0.0);
	}
	
	@Test
	public void testBuyAnyThreeAndGetCheapestOneFreePromotion3() {
		Cart cart = new Cart();
		cart.addOrder(Item.C);
		cart.addOrder(Item.D);
		cart.addOrder(Item.E);
		cart.addOrder(Item.F);
		cart.addOrder(Item.G);
		CartService cartService = new CartService();
		double finalPrice = cartService.calculateFinalPrice(cart);
		assertEquals(27.0, finalPrice, 0.0);
	}


}
