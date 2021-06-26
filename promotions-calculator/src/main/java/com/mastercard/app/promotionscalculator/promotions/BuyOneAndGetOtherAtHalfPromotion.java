package com.mastercard.app.promotionscalculator.promotions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.mastercard.app.promotionscalculator.model.Cart;
import com.mastercard.app.promotionscalculator.model.Item;

public class BuyOneAndGetOtherAtHalfPromotion implements Promotion {

	public static final Set<Item> eligibleItems = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList(Item.A, Item.B)));

	@Override
	public Double getDiscount(Cart cart) {
		Double discount = 0.0;
		if (!cart.getOrders().isEmpty() && cart.getOrders().containsAll(eligibleItems)) {
			Map<Item, Long> itemBySize = cart.getOrders().stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			Long itemASize = itemBySize.get(Item.A);
			Long itemBSize = itemBySize.get(Item.B);
			if (itemBSize >= itemASize) {
				discount = (Item.B.getPrice() * itemASize) / 2;
			} else {
				discount = (Item.B.getPrice() * itemBSize) / 2;
			}
		}
		return discount;
	}

}
