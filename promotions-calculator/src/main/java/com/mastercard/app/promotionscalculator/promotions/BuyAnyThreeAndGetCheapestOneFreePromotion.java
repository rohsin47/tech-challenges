package com.mastercard.app.promotionscalculator.promotions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mastercard.app.promotionscalculator.model.Cart;
import com.mastercard.app.promotionscalculator.model.Item;

public class BuyAnyThreeAndGetCheapestOneFreePromotion implements Promotion {

	public static final Set<Item> eligibleItems = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList(Item.C, Item.D, Item.E, Item.F, Item.G)));

	@Override
	public Double getDiscount(Cart cart) {
		Double discount = 0.0;
		if (!cart.getOrders().isEmpty()) {
			List<Item> eligibleCarts = cart.getOrders().stream()
					.filter(eligibleItems::contains)
					.collect(Collectors.toList());
			if (eligibleCarts.size() >= 3) {
				discount = eligibleCarts.stream()
						.map(Item::getPrice)
						.min(Comparator.naturalOrder())
						.orElse(discount);
			}
		}
		return discount;
	}

}
