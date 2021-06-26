package com.crypto.app.price;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crypto.app.event.Event;
import com.crypto.app.event.EventHandler;
import com.crypto.app.event.EventListener;
import com.crypto.app.model.Portfolio;
import com.crypto.app.model.Price;
import com.crypto.app.portfolio.PortfolioEvent;
import com.crypto.app.price.PriceEvent;
import com.crypto.app.service.impl.PositionService;

/**
 * @author rohsi
 *
 */
@Component
public class PriceEventListener implements EventListener {

    @Autowired
    PositionService positionService;

    @Autowired
    EventHandler eventDispatcher;

    @Override
    public void onEvent(Event event) {
        if (event instanceof PriceEvent) {

            List<Price> prices = ((PriceEvent) event).getPrice();

            Portfolio portfolio = new Portfolio();

            positionService.getPositions(getClass().getResourceAsStream("/position.csv")).stream().forEach(pos -> {

                if ("Buy".equals(pos.getPosType()) || "Sell".equals(pos.getPosType())) {
                    int sign = pos.getPosType().equals("Buy") ? 1 : -1;
                    portfolio.stockPosition = sign * prices.get(0).getStock() + pos.getShares();

                } else if ("Put".equals(pos.getPosType())) {
                    portfolio.putPosition = prices.get(0).getPut() * pos.getShares();

                } else if ("Call".equals(pos.getPosType())) {
                    portfolio.callPosition = prices.get(0).getCall() * pos.getShares();
                }
            });

            eventDispatcher.handle(new PortfolioEvent(portfolio));
        }
    }
}
