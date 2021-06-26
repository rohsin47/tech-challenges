package com.cs.app.factory;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.junit.Assert.*;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.app.command.BucketFillCommand;
import com.cs.app.command.CreateCanvasCommand;
import com.cs.app.command.DrawLineCommand;
import com.cs.app.command.DrawRectangleCommand;
import com.cs.app.command.context.Command;
import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {
    
    @Mock
    CommandContext ctx;
    
    @InjectMocks
    CommandFactory commandFactory;
    
    @Test
    public void shouldReturnCanvasCommand() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("2", "4");
        when(ctx.getCommand()).thenReturn(CommandType.CANVAS);
        when(ctx.getParams()).thenReturn(params);
        
        // when
        Command result = commandFactory.getCommand(ctx);
        
        // then
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof CreateCanvasCommand); 
    }
    
    @Test
    public void shouldReturnLineCommand() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("1", "2", "6", "2");
        when(ctx.getCommand()).thenReturn(CommandType.LINE);
        when(ctx.getParams()).thenReturn(params);
        
        // when
        Command result = commandFactory.getCommand(ctx);
        
        // then
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof DrawLineCommand); 
    }

    @Test
    public void shouldReturnRectangleCommand() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("2", "4", "6", "1");
        when(ctx.getCommand()).thenReturn(CommandType.RECTANGLE);
        when(ctx.getParams()).thenReturn(params);
        
        // when
        Command result = commandFactory.getCommand(ctx);
        
        // then
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof DrawRectangleCommand); 
    }

    
    @Test
    public void shouldReturnFillCommand() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("2", "4", "o");
        when(ctx.getCommand()).thenReturn(CommandType.FILL);
        when(ctx.getParams()).thenReturn(params);
        
        // when
        Command result = commandFactory.getCommand(ctx);
        
        // then
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof BucketFillCommand); 
    }
    
    @Test(expected = CommandNotValidException.class)
    public void shouldThrowLineException() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("2", "4", "6", "1");
        when(ctx.getCommand()).thenReturn(CommandType.LINE);
        when(ctx.getParams()).thenReturn(params);
        
        // when
        commandFactory.getCommand(ctx);
    }


}
