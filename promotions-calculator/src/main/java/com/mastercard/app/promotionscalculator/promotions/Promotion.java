package com.mastercard.app.promotionscalculator.promotions;

import com.mastercard.app.promotionscalculator.model.Cart;

public interface Promotion {
	
	Double getDiscount(Cart cart);

}
