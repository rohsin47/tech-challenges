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
public class DrawLineCommandTest {
    
    DrawLineCommand drawLineCommand;
    
    CommandContext commnandCtx;

    @Test
    public void shouldHaveDrawLineCommand() throws CommandNotValidException {  
        commnandCtx = new CommandContext("L 1 2 6 2");
        drawLineCommand = new DrawLineCommand(commnandCtx);
        
        assertNotNull(drawLineCommand);
        assertThat(drawLineCommand.getX1(), is(1));
        assertThat(drawLineCommand.getY1(), is(2));
        assertThat(drawLineCommand.getX2(), is(6));
        assertThat(drawLineCommand.getY2(), is(2));
    }
    
    @Test(expected=CommandNotValidException.class)
    public void shouldThrowException() throws CommandNotValidException {
        commnandCtx = new CommandContext("L 1 2");
        drawLineCommand = new DrawLineCommand(commnandCtx);
    }


}
