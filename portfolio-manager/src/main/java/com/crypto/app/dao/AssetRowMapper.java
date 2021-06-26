/**
 * 
 */
package com.crypto.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crypto.app.model.Asset;
import com.crypto.app.model.AssetType;

/**
 * @author rohsi
 *
 */
public class AssetRowMapper implements RowMapper<Asset> {

	@Override
	public Asset mapRow(ResultSet rs, int rowNum) throws SQLException {
		Asset asset = new Asset();
		asset.setTicker(rs.getString("ticker"));
		asset.setAssetType(AssetType.resolveAsset(rs.getString("sec_type")));
		asset.setStrike(rs.getInt("strike"));
		asset.setStockPrice(rs.getInt("stock_price"));
		asset.setInterest(rs.getDouble("interest"));
		asset.setVolatility(rs.getDouble("volatility"));
		asset.setTimeHorizon(rs.getDouble("time_horizon"));
		return asset;
	}

}
