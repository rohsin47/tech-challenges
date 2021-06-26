/**
 * 
 */
package com.cs.app.command;

import com.cs.app.command.context.CanvasCommand;
import com.cs.app.model.ICanvas;

/**
 * @author rohsi
 *
 */
public class AbstractCanvasCommand implements CanvasCommand {
	
	private ICanvas canvas;

	@Override
	public void setCanvas(ICanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void execute() {
		System.out.println(canvas.display());	
	}

}
