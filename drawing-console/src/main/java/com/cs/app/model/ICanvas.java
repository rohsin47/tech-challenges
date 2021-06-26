package com.cs.app.model;

import com.cs.app.exception.ShapeOutsideCanvasException;

/**
 * @author rohsi
 *
 */
public interface ICanvas {
	
	void addShape(Shape shape) throws ShapeOutsideCanvasException;
	
	String display();

}
