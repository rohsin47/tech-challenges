/**
 * 
 */
package com.cs.app.factory;

import com.cs.app.command.BucketFillCommand;
import com.cs.app.command.DrawLineCommand;
import com.cs.app.command.DrawRectangleCommand;
import com.cs.app.command.context.Command;
import com.cs.app.exception.CommandNotValidException;
import com.cs.app.model.Bucket;
import com.cs.app.model.Line;
import com.cs.app.model.Rectangle;
import com.cs.app.model.Shape;

/**
 * @author rohsi
 *
 */
public class ShapeFactory implements AbstractFactory {

	public Shape getShape(Command command) throws CommandNotValidException {
		if (command instanceof DrawLineCommand) {
			return createLine((DrawLineCommand) command);

		} else if (command instanceof DrawRectangleCommand) {
			return createRectangle((DrawRectangleCommand) command);

		} else if (command instanceof BucketFillCommand) {
			return createBucketFill((BucketFillCommand) command);
		}
		return null;
	}
	
	private Line createLine(DrawLineCommand cmd) throws CommandNotValidException {
		return new Line(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
	}

	private Rectangle createRectangle(DrawRectangleCommand cmd) throws CommandNotValidException {
		return new Rectangle(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
	}

	private Bucket createBucketFill(BucketFillCommand cmd) throws CommandNotValidException {
		return new Bucket(cmd.getX(), cmd.getY(), cmd.getFillColor());
	}
}
