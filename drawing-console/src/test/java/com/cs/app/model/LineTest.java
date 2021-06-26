package com.cs.app.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LineTest {
    
    Line line;
    
    @Before
    public void setUp() throws Exception {
        line = new Line(1, 2, 6, 2);
    }

    @Test
    public void shouldValidate() {
        boolean result = line.validate();
        
        assertTrue(result);
    }

}
