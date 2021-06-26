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
public class BucketFillCommandTest {

    BucketFillCommand bucketFillCommand;
    
    CommandContext commnandCtx;

    @Test
    public void shouldHaveFillBucketCommand() throws CommandNotValidException {  
        commnandCtx = new CommandContext("B 10 3 o");
        bucketFillCommand = new BucketFillCommand(commnandCtx);
        
        assertNotNull(bucketFillCommand);
        assertThat(bucketFillCommand.getX(), is(10));
        assertThat(bucketFillCommand.getY(), is(3));
        assertThat(bucketFillCommand.getFillColor(), is("o"));
    }
    
    @Test(expected=CommandNotValidException.class)
    public void shouldThrowException() throws CommandNotValidException {
        commnandCtx = new CommandContext("B 1 2");
        bucketFillCommand = new BucketFillCommand(commnandCtx);
    }

}
