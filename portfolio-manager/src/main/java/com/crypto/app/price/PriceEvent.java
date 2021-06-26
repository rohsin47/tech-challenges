package com.crypto.app.price;

import java.util.List;

import com.crypto.app.event.Event;
import com.crypto.app.model.Price;

/**
 * @author rohsi
 *
 */
public class PriceEvent extends Event {
	
	List<Price> prices;

    public PriceEvent(List<Price> prices) {
        super();
        this.prices = prices;
    }

    public List<Price> getPrice() {
        return prices;
    }

    public void setPrice(List<Price> prices) {
        this.prices = prices;
    }

	
	
}
