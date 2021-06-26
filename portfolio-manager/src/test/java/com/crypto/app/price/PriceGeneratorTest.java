package com.crypto.app.price;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.assertj.core.util.Lists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crypto.app.event.Event;
import com.crypto.app.event.EventHandler;
import com.crypto.app.model.Asset;
import com.crypto.app.model.Price;
import com.crypto.app.service.impl.AssetService;
import com.crypto.app.service.impl.PriceService;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PriceGeneratorTest {
    
    @Mock
    AssetService assetService;

    @Mock
    PriceService priceService;

    @Mock
    EventHandler eventDispatcher;
    
    @InjectMocks
    PriceGenerator generator;
    
    @Test
    public void shouldGenerate() {     
        Asset asset = mock(Asset.class);
        Price price = mock(Price.class);
        
        when(assetService.getAssetDetails()).thenReturn(Lists.newArrayList(asset));     
        when(priceService.getPrices(any(Asset.class))).thenReturn(Lists.newArrayList(price));
        doNothing().when(eventDispatcher).handle(any(Event.class));
        
        generator.generate();
        
        verify(assetService, times(1)).getAssetDetails();
        verify(priceService, times(1)).getPrices(any(Asset.class));
        verify(eventDispatcher).handle(any(Event.class));
    }
    
    

}
