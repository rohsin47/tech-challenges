package com.crypto.app.event;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.crypto.app.price.PriceEvent;
import com.crypto.app.price.PriceEventListener;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EventHandlerTest {
    
    EventHandler dispatcher;
    
    @Before
    public void setUp() {
        dispatcher = new EventHandler();
    }

    @Test
    public void shouldRegisterHandler() {
        // given
        dispatcher.registerHandler(PriceEvent.class, new PriceEventListener());
        
        // when
        EventListener result = dispatcher.getHandlers().get(PriceEvent.class);
        
        // then
        assertNotNull(result);
        assertTrue(result instanceof PriceEventListener);
    }
    
    @Test
    public void shouldDeregisterHandler() {
        // given
        dispatcher.registerHandler(PriceEvent.class, new PriceEventListener());
        dispatcher.deregisterHandler(PriceEvent.class);
        
        // when
        EventListener result = dispatcher.getHandlers().get(PriceEvent.class);
        
        // then
        assertNull(result);
    }
}
