/*
* Copyright (C) 2020 BlackRock.
*
* Created on Jan 23, 2020
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.cs.app.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RectangleTest {
    
    Rectangle rectangle;
    
    @Before
    public void setUp() throws Exception {
        rectangle = new Rectangle(14, 1, 18, 3);
    }

    @Test
    public void shouldValidate() {
        boolean result = rectangle.validate();
        
        assertTrue(result);
    }

}
