package com.crypto.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.crypto.app.model.Asset;
import com.crypto.app.model.Price;
import com.crypto.app.service.IPriceService;

/**
 * @author rohsingh
 *
 */
@Service
public class PriceService implements IPriceService {
	
	private static final int paths; // number of random walks we will compute
	private static final int steps; // 6 months expressed in days.
	static {
		paths = 100;
		steps = (int) Math.ceil(365.0 / 2.0);
	}

	@Override
	public List<Price> getPrices(Asset asset) {
	    List<Price> prices = new ArrayList<>();
	    double callPayoff = 0.0;
	    double putPayoff = 0.0;
	    double finalStockPrice = 0.0;
		double dt = asset.getTimeHorizon() / steps;  // size of the step where each step is 1 day
        for (int i = 0; i < paths ; i ++) {
            // Return final projected Stock Price st = stock at time t
            finalStockPrice = simulateRandomWalk(steps, asset.getStockPrice(), dt, asset.getInterest(), asset.getVolatility());
            callPayoff += Math.max(finalStockPrice-asset.getStrike(), 0);
            putPayoff += Math.max(asset.getStockPrice()-finalStockPrice, 0);
        }
        
        double callPrice =  Math.exp(-asset.getInterest() * asset.getTimeHorizon()) * callPayoff / paths;
        double putPrice = Math.exp(-asset.getInterest() * asset.getTimeHorizon()) * putPayoff / paths;
        
        prices.add(new Price(asset.getTicker(), finalStockPrice, callPrice, putPrice));
        return prices;
	}
	
    private double simulateRandomWalk(int n, double s0, double dt, double interest, double sigma) {
        double st = s0;
        for (int t = 1; t < n; t++) {
            double dz = randPrice(dt);
            st = st + (interest * st * dt) + (sigma * st * dz);
        }
        return st;
    }
    
    private double randPrice(double dt) {
        Random random = new Random();
        double epsilon = random.nextGaussian();
        return epsilon * Math.sqrt(dt);
    }

}
