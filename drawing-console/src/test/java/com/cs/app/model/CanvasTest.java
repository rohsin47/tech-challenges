package com.cs.app.model;

import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.app.processor.CanvasProcessor;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CanvasTest {

    @Mock
    CanvasProcessor canvasProcessor;
    
    List<Shape> shapes;
    
    Canvas canvas;
    
    @Before
    public void setUp() {
        int width = 20;
        int height = 4;
        canvas = new Canvas(width, height);
        canvas.setCanvasProcessor(canvasProcessor);
    }

    @Test
    public final void shouldAddLine() throws Exception {
        // given
        Line line = mock(Line.class);
        doNothing().when(canvasProcessor).addLine(any());
        
        // when
        canvas.addShape(line);
        
        // then
        assertThat(canvas.getShapes(), is(notNullValue()));
        assertThat(canvas.getShapes().size(), is(1));
    }
    
    @Test
    public final void shouldAddRectangle() throws Exception {
        // given
        Rectangle rect = mock(Rectangle.class);
        doNothing().when(canvasProcessor).addRectangle(any());
        
        // when
        canvas.addShape(rect);
        
        // then
        assertThat(canvas.getShapes(), is(notNullValue()));
        assertThat(canvas.getShapes().size(), is(1));
    }
    
    
    @Test
    public final void shouldAddBucket() throws Exception {
        // given
        Bucket bucket = mock(Bucket.class);
        doNothing().when(canvasProcessor).addBucketFill(any());
        
        // when
        canvas.addShape(bucket);
        
        // then
        assertThat(canvas.getShapes(), is(notNullValue()));
        assertThat(canvas.getShapes().size(), is(1));
    }
    
    @Test
    public final void shouldDisplay() {
        String result = canvas.display();
        
        assertThat(result, is(notNullValue()));
        assertThat(result.isEmpty(), is(false));
    }

}
