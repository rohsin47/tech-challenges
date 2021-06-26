/**
 * 
 */
package com.crypto.app.service;


import java.util.List;

import com.crypto.app.model.Asset;

/**
 * @author rohsi
 *
 */
public interface IAssetService {
	
	Asset getAssetDetailByTicker(String ticker);
	
	List<Asset> getAssetDetails();

}
