package com.crypto.app.price;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.InputStream;

import org.assertj.core.util.Lists;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crypto.app.event.Event;
import com.crypto.app.event.EventHandler;
import com.crypto.app.model.Position;
import com.crypto.app.model.Price;
import com.crypto.app.service.impl.PositionService;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PriceEventListenerTest {
    
    @Mock
    PositionService positionService;

    @Mock
    EventHandler eventDispatcher;
    
    @Mock
    PriceEvent event;
    
    @InjectMocks
    PriceEventListener eventListener;
    
    @Test
    public void shouldActionPriceEvent() {
        Price price = mock(Price.class);
        Position pos = mock(Position.class);
        
        when(event.getPrice()).thenReturn(Lists.newArrayList(price));
        when(positionService.getPositions(any(InputStream.class))).thenReturn(Lists.newArrayList(pos));
        doNothing().when(eventDispatcher).handle(any(Event.class));
        
        eventListener.onEvent(event);
        
        verify(event, times(1)).getPrice();
        verify(positionService, times(1)).getPositions(any(InputStream.class));
        verify(eventDispatcher).handle(any(Event.class));
    }

}
