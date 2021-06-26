/*
* Copyright (C) 2020 BlackRock.
*
* Created on Feb 6, 2020
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.crypto.app.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crypto.app.dao.AssetDao;
import com.crypto.app.model.Asset;
import com.crypto.app.service.impl.AssetService;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AssetServiceTest {

    @Mock
    AssetDao assetDao;

    @InjectMocks
    AssetService service;

    @Test
    public void shouldGetAssetDetailByTicker() {
        // given
        when(assetDao.getAssetByTicker(anyString())).thenReturn(new Asset());

        // when
        Asset result = service.getAssetDetailByTicker("test");

        // then
        assertNotNull(result);
    }

    @Test
    public void shouldGetAssetDetails() {
        // given
        when(assetDao.getAllAssets()).thenReturn(Lists.newArrayList(new Asset()));

        // when
        List<Asset> result = service.getAssetDetails();

        // then
        assertNotNull(result);
        assertThat(result.size(), is(1));
    }

}
