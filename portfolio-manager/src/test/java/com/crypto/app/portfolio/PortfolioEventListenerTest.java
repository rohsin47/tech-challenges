package com.crypto.app.portfolio;

import static org.mockito.Mockito.when;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crypto.app.model.Portfolio;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PortfolioEventListenerTest {
    
    @Mock
    PortfolioEvent event;
    
    @InjectMocks
    PortfolioEventListener eventListener;
    
    @Test
    public void shouldActionPortfolioEvent() {
        // given
        Portfolio port = mock(Portfolio.class);     
        when(event.getPortfolio()).thenReturn(port);
        
        // when
        eventListener.onEvent(event);
        
        // then
        verify(event, times(1)).getPortfolio();
    }
    
    

}
