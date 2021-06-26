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
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.crypto.app.model.Asset;
import com.crypto.app.model.Price;
import com.crypto.app.service.impl.PriceService;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {
    
    @InjectMocks
    PriceService service;
    
    @Test
    public void shouldReturnPrices() {
        // given
        Asset asset = mock(Asset.class);
        
        // when
        List<Price> prices = service.getPrices(asset);
        
        // then
        assertNotNull(prices);
        assertFalse(prices.isEmpty());
    }

}
