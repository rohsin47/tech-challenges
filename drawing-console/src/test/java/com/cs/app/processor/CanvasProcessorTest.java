package com.cs.app.processor;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.app.exception.ShapeOutsideCanvasException;
import com.cs.app.model.Bucket;
import com.cs.app.model.Line;
import com.cs.app.model.Rectangle;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CanvasProcessorTest {

    CanvasProcessor canvasProcessor;
    
    @Before
    public void setUp() {
    	canvasProcessor = new CanvasProcessor();
    	canvasProcessor.setBody(new String[4][22]).setWidth(20).setHeight(4);
    }

    @Test
    public void shouldDrawLine() throws ShapeOutsideCanvasException {       
        Line line = new Line(1,2,6,2);
        canvasProcessor.addLine(line);        
        assertThat(canvasProcessor, is(notNullValue()));
    }
    
    @Test
    public void shouldDrawRectangle() throws ShapeOutsideCanvasException {        
        Rectangle rect = new Rectangle(14,1,18,3);
        canvasProcessor.addRectangle(rect);
        assertThat(canvasProcessor, is(notNullValue()));
    }
    
    @Test
    public void shouldFillBucket() throws ShapeOutsideCanvasException {   
        Bucket bucket = new Bucket(10,3,"o");
        canvasProcessor.addBucketFill(bucket);
        assertThat(canvasProcessor, is(notNullValue()));
    }
    
    @Test(expected=ShapeOutsideCanvasException.class)
    public void shouldThrowExceptionForLine() throws ShapeOutsideCanvasException {
        Line line = new Line(80,20,60,40);
        canvasProcessor.addLine(line);
    }
    
    @Test(expected=ShapeOutsideCanvasException.class)
    public void shouldThrowExceptionForRectangle() throws ShapeOutsideCanvasException {
        Rectangle rect = new Rectangle(80,20,60,40);
        canvasProcessor.addRectangle(rect);
    }
    
    @Test(expected=ShapeOutsideCanvasException.class)
    public void shouldThrowExceptionForFill() throws ShapeOutsideCanvasException {
        Bucket bucket = new Bucket(80,20,"o");
        canvasProcessor.addBucketFill(bucket);
    }

}
