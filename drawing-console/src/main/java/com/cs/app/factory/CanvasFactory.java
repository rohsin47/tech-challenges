/**
 * 
 */
package com.cs.app.factory;

import com.cs.app.command.CreateCanvasCommand;
import com.cs.app.command.context.Command;
import com.cs.app.exception.CommandNotValidException;
import com.cs.app.model.Canvas;
import com.cs.app.model.ICanvas;

/**
 * @author rohsi
 *
 */
public class CanvasFactory implements AbstractFactory {

	public ICanvas getCanvas(Command command) throws CommandNotValidException {
		return createCanvas((CreateCanvasCommand) command);
	}
	
	private ICanvas createCanvas(CreateCanvasCommand command) throws CommandNotValidException {
		return new Canvas(command.getWidth(), command.getHeight());
	}
}
