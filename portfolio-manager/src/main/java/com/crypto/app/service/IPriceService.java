/**
 * 
 */
package com.crypto.app.service;

import java.util.List;

import com.crypto.app.model.Asset;
import com.crypto.app.model.Price;

/**
 * @author rohsi
 *
 */
@FunctionalInterface
public interface IPriceService {
	
	List<Price> getPrices(Asset asset);
	
}
