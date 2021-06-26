package com.cs.app.command.context;

import com.cs.app.model.ICanvas;

/**
 * @author rohsingh
 *
 */
public interface CanvasCommand extends Command {

	void setCanvas(ICanvas canvas);
}
