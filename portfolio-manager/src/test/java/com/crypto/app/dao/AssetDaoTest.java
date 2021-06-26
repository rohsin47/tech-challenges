package com.crypto.app.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.crypto.app.model.Asset;

@RunWith(MockitoJUnitRunner.class)
public class AssetDaoTest {
    
    @Mock
    JdbcTemplate template;
    
    @Mock
    AssetRowMapper rowMapper;
    
    @InjectMocks
    AssetDao assetDao;

    @Test
    public void shouldGetAssetByTicker() throws SQLException {
        // given
        when(template.queryForObject(anyString(), Matchers.<Object[]> anyVararg(), Matchers.<AssetRowMapper>any())).thenReturn(new Asset());
        
        // when
        Asset asset = assetDao.getAssetByTicker("test");
        
        // then
        assertNotNull(asset);      
    }

    @Test
    public void shouldGetAllAssets() throws SQLException {
        // given
        when(template.queryForObject(anyString(), anyObject(), Matchers.<AssetRowMapper>any())).thenReturn(new Asset());
        
        // when
        List<Asset> assets = assetDao.getAllAssets();
        
        // then
        assertNotNull(assets);      
    }

}
