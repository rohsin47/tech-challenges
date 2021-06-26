package com.mastercard.app.promotionscalculator.promotions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mastercard.app.promotionscalculator.model.Cart;
import com.mastercard.app.promotionscalculator.model.Item;

public class BuyOneAndGetOtherAtHalfPromotionTest {
	
	@Test
	public void testGetDiscountWithEmptyCart() {
		Promotion promo = new BuyOneAndGetOtherAtHalfPromotion();
		double result = promo.getDiscount(new Cart());
		assertTrue(Double.compare(result, 0.0) == 0);
	}
	
	@Test
	public void testGetDiscountWithItemsInCart() {
		Promotion promo = new BuyOneAndGetOtherAtHalfPromotion();
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.B);
		cart.addOrder(Item.B);
		double result = promo.getDiscount(cart);
		assertTrue(Double.compare(result, 4.5) == 0);
	}

	@Test
	public void testGetDiscountWithItemsInCart2() {
		Promotion promo = new BuyOneAndGetOtherAtHalfPromotion();
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.A);
		cart.addOrder(Item.B);
		double result = promo.getDiscount(cart);
		assertTrue(Double.compare(result, 4.5) == 0);
	}
	
	@Test
	public void testGetDiscountWithItemsInCart3() {
		Promotion promo = new BuyOneAndGetOtherAtHalfPromotion();
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.A);
		cart.addOrder(Item.B);
		cart.addOrder(Item.B);
		double result = promo.getDiscount(cart);
		assertTrue(Double.compare(result, 9.0) == 0);
	}
	
	@Test
	public void testGetDiscountWithItemsInCart4() {
		Promotion promo = new BuyOneAndGetOtherAtHalfPromotion();
		Cart cart = new Cart();
		cart.addOrder(Item.A);
		cart.addOrder(Item.A);
		double result = promo.getDiscount(cart);
		assertTrue(Double.compare(result, 0.0) == 0);
	}
	
	@Test
	public void testGetDiscountWithItemsInCart5() {
		Promotion promo = new BuyOneAndGetOtherAtHalfPromotion();
		Cart cart = new Cart();
		cart.addOrder(Item.B);
		cart.addOrder(Item.B);
		double result = promo.getDiscount(cart);
		assertTrue(Double.compare(result, 0.0) == 0);
	}
}
