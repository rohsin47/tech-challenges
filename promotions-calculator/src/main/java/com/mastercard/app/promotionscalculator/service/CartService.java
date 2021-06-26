package com.mastercard.app.promotionscalculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.mastercard.app.promotionscalculator.model.Cart;
import com.mastercard.app.promotionscalculator.promotions.BuyAnyThreeAndGetCheapestOneFreePromotion;
import com.mastercard.app.promotionscalculator.promotions.BuyOneAndGetOtherAtHalfPromotion;
import com.mastercard.app.promotionscalculator.promotions.Promotion;

public class CartService {
	
	private static final Logger log = Logger.getLogger(CartService.class.getSimpleName());

	List<Promotion> promotions;

	public CartService() {
		this.promotions = Arrays.asList(
				new BuyOneAndGetOtherAtHalfPromotion(),
				new BuyAnyThreeAndGetCheapestOneFreePromotion());

	}

	public Double calculateFinalPrice(Cart cart) {
		if (!cart.getOrders().isEmpty()) {
			double discount = 0.0;
			for (Promotion promotion : promotions) {
				discount += promotion.getDiscount(cart);
			}
			log.info("Found discount for "+cart+ " : "+discount);
			return cart.cartPrice() - discount;
		}
		return Double.valueOf(0.0);
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

}
