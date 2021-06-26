package com.cs.app.command;

import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;

/**
 * @author rohsingh
 *
 */
public class DrawRectangleCommand extends AbstractShapeCommand {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public DrawRectangleCommand(CommandContext ctx) throws CommandNotValidException {
		if (ctx.getParams().size() < 4) {
			throw new CommandNotValidException(
					"Rectangle command requires 4 parameters, " + ctx.getParams().size() + " params provided.");
		}

		this.x1 = Integer.parseInt(ctx.getParams().get(0));
		this.y1 = Integer.parseInt(ctx.getParams().get(1));
		this.x2 = Integer.parseInt(ctx.getParams().get(2));
		this.y2 = Integer.parseInt(ctx.getParams().get(3));
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

}
