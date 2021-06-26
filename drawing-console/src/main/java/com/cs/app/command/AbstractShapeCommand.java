/**
 * 
 */
package com.cs.app.command;

import com.cs.app.command.context.ShapeCommand;
import com.cs.app.exception.ShapeOutsideCanvasException;
import com.cs.app.model.ICanvas;
import com.cs.app.model.Shape;

/**
 * @author rohsi
 *
 */
public class AbstractShapeCommand implements ShapeCommand {

	private ICanvas canvas;
	private Shape shape;

	@Override
	public void execute() {
		try {
			canvas.addShape(shape);
			System.out.println(canvas.display());
		} catch (ShapeOutsideCanvasException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setCanvas(ICanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
