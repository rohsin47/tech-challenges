package com.cs.app.factory;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import static org.junit.Assert.*;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.app.model.Bucket;
import com.cs.app.model.Line;
import com.cs.app.model.Rectangle;
import com.cs.app.model.Shape;
import com.cs.app.command.BucketFillCommand;
import com.cs.app.command.DrawLineCommand;
import com.cs.app.command.DrawRectangleCommand;
import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ShapeFactoryTest {

    @Mock
    CommandContext ctx;
    
    @InjectMocks
    ShapeFactory shapeFactory;
    
    @Test
    public void shouldCreateLineShape() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("1", "2", "6", "2");
        when(ctx.getCommand()).thenReturn(CommandType.LINE);
        when(ctx.getParams()).thenReturn(params);

        Shape result = shapeFactory.getShape(new DrawLineCommand(ctx));
        
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof Line);
    }
    
    @Test
    public void shouldCreateRectangleShape() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("2", "4", "6", "1");
        when(ctx.getCommand()).thenReturn(CommandType.RECTANGLE);
        when(ctx.getParams()).thenReturn(params);

        Shape result = shapeFactory.getShape(new DrawRectangleCommand(ctx));
        
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof Rectangle);
    }
    
    @Test
    public void shouldCreateBucketShape() throws CommandNotValidException {
        // given
        List<String> params = Lists.newArrayList("2", "4", "o");
        when(ctx.getCommand()).thenReturn(CommandType.FILL);
        when(ctx.getParams()).thenReturn(params);

        Shape result = shapeFactory.getShape(new BucketFillCommand(ctx));
        
        assertThat(result, is(notNullValue()));
        assertTrue(result instanceof Bucket);
    }
}
