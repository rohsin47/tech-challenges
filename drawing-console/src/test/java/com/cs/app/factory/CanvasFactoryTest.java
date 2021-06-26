package com.cs.app.factory;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.app.command.CreateCanvasCommand;
import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;
import com.cs.app.model.Canvas;
import com.cs.app.model.ICanvas;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CanvasFactoryTest {

    @Mock
    CommandContext ctx;
    
    @InjectMocks
    CanvasFactory canvasFactory;
    
    @Test
    public void shouldCreateCanvas() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("2", "4", "6", "1");
        when(ctx.getCommand()).thenReturn(CommandType.LINE);
        when(ctx.getParams()).thenReturn(params);

        ICanvas result = canvasFactory.getCanvas(new CreateCanvasCommand(ctx));
        
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof Canvas);
    }
}
