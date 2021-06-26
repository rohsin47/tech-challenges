package com.crypto.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crypto.app.model.Asset;

/**
 * @author rohsi
 *
 */
@Repository
public class AssetDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Asset getAssetByTicker(String ticker) {
		Asset asset = (Asset) jdbcTemplate.queryForObject("select * from asset_detail where ticker = ?",
				new Object[] { ticker}, new AssetRowMapper());
		return asset;
	}
	
	public List<Asset> getAllAssets() {
		List<Asset> assetDetails = (List<Asset>) jdbcTemplate.query("select * from asset_detail",
				new AssetRowMapper());
		return assetDetails;
	}

}
