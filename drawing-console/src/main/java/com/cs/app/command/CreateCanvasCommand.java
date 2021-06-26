package com.cs.app.command;

import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;

/**
 * @author rohsingh
 *
 */
public class CreateCanvasCommand extends AbstractCanvasCommand {

	private int width;
	private int height;

	public CreateCanvasCommand(CommandContext ctx) throws CommandNotValidException {
		if (ctx.getParams().size() < 2)
			throw new CommandNotValidException(
					"Canvas command requires 2 parameters, " + ctx.getParams().size() + " params provided.");

		this.width = Integer.parseInt(ctx.getParams().get(0));
		this.height = Integer.parseInt(ctx.getParams().get(1));
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
