package com.cs.app.command.context;

import com.cs.app.model.Shape;

/**
 * @author rohsi
 *
 */
public interface ShapeCommand extends CanvasCommand {
	
	void setShape(Shape shape);

}
