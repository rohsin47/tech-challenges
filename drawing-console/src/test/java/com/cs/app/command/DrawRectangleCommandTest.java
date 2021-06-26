package com.cs.app.command;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DrawRectangleCommandTest {
    
    DrawRectangleCommand drawRectangleCommand;
    
    CommandContext commnandCtx;

    @Test
    public void shouldHaveDrawRectangleCommand() throws CommandNotValidException {  
        commnandCtx = new CommandContext("R 14 1 18 3");
        drawRectangleCommand = new DrawRectangleCommand(commnandCtx);
        
        assertNotNull(drawRectangleCommand);
        assertThat(drawRectangleCommand.getX1(), is(14));
        assertThat(drawRectangleCommand.getY1(), is(1));
        assertThat(drawRectangleCommand.getX2(), is(18));
        assertThat(drawRectangleCommand.getY2(), is(3));
    }
    
    @Test(expected=CommandNotValidException.class)
    public void shouldThrowException() throws CommandNotValidException {
        commnandCtx = new CommandContext("R 1 2");
        drawRectangleCommand = new DrawRectangleCommand(commnandCtx);
    }


}
