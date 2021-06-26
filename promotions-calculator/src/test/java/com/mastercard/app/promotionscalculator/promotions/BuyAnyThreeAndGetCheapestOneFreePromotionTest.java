package com.mastercard.app.promotionscalculator.promotions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mastercard.app.promotionscalculator.model.Cart;
import com.mastercard.app.promotionscalculator.model.Item;

public class BuyAnyThreeAndGetCheapestOneFreePromotionTest {

	@Test
	public void testGetDiscountWithEmptyCart() {
		Promotion promo = new BuyAnyThreeAndGetCheapestOneFreePromotion();
		double result = promo.getDiscount(new Cart());
		assertTrue(Double.compare(result, 0.0) == 0);
	}
	
	@Test
	public void testGetDiscountWithItemsInCart() {
		Promotion promo = new BuyAnyThreeAndGetCheapestOneFreePromotion();
		Cart cart = new Cart();
		cart.addOrder(Item.C);
		cart.addOrder(Item.D);
		cart.addOrder(Item.E);
		cart.addOrder(Item.H);
		double result = promo.getDiscount(cart);
		assertTrue(Double.compare(result, 4.0) == 0);
	}

}
