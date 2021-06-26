package com.cs.app.command;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

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
public class CreateCanvasCommandTest {
    
    CreateCanvasCommand createCanvasCommand;
    
    CommandContext commnandCtx;

    @Test
    public void shouldCreateCanvasCommand() throws CommandNotValidException {  
        commnandCtx = new CommandContext("C 20 4");
        createCanvasCommand = new CreateCanvasCommand(commnandCtx);
        
        assertNotNull(createCanvasCommand);
        assertThat(createCanvasCommand.getWidth(), is(20));
        assertThat(createCanvasCommand.getHeight(), is(4));
    }
    
    @Test(expected=CommandNotValidException.class)
    public void shouldThrowException() throws CommandNotValidException {
        commnandCtx = new CommandContext("C 20");
        createCanvasCommand = new CreateCanvasCommand(commnandCtx);
    }

}
