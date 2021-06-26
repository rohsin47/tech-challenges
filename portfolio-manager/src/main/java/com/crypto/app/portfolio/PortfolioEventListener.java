package com.crypto.app.portfolio;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.crypto.app.event.Event;
import com.crypto.app.event.EventListener;
import com.crypto.app.model.Portfolio;

/**
 * @author rohsi
 *
 */
@Component
public class PortfolioEventListener implements EventListener {

    private static final Logger log = LoggerFactory.getLogger(PortfolioEventListener.class);

    @Override
    public void onEvent(Event event) {

        if (event instanceof PortfolioEvent) {
            
            Portfolio portfolio = ((PortfolioEvent) event).getPortfolio();
            
            if(portfolio != null) {
                
                log.info("------------- Positions & NAV @ [{}]  ----------------", LocalDateTime.now());
                log.info("Position  [STOCK] : {}", portfolio.stockPosition);
                log.info("Position  [PUT]   : {}", portfolio.putPosition);
                log.info("Position  [CALL]  : {}", portfolio.callPosition);
                log.info("Portfolio [NAV]   : {}", portfolio.getNAV());
                log.info("---------------------------------------------------------------------------");
            }

        }
    }
}
