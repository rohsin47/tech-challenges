package com.crypto.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.crypto.app.dao.AssetDao;
import com.crypto.app.model.Asset;
import com.crypto.app.service.IAssetService;

/**
 * @author rohsi
 *
 */
public class AssetService implements IAssetService {
	
	@Autowired
	private AssetDao assetDao;

	@Override
	public Asset getAssetDetailByTicker(String ticker) {
		return assetDao.getAssetByTicker(ticker);
	}
	
	@Override
	public List<Asset> getAssetDetails() {
		return assetDao.getAllAssets();
	}

}
