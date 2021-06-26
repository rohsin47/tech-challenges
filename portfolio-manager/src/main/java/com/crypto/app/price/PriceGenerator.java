package com.crypto.app.price;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crypto.app.event.EventHandler;
import com.crypto.app.model.Asset;
import com.crypto.app.model.Price;
import com.crypto.app.service.impl.AssetService;
import com.crypto.app.service.impl.PriceService;

/**
 * @author rohsi
 *
 */
@Component
public class PriceGenerator {

    @Autowired
    AssetService assetService;

    @Autowired
    PriceService priceService;

    @Autowired
    EventHandler eventDispatcher;

    public void generate() {
        List<Asset> assets = assetService.getAssetDetails();
        if (assets != null) {
            assets.stream().forEach(asset -> {
                List<Price> prices = priceService.getPrices(asset);
                eventDispatcher.handle(new PriceEvent(prices));
            });

        }

    }

}
