package com.cs.app.command;


import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;

/**
 * @author rohsingh
 *
 */
public class BucketFillCommand extends AbstractShapeCommand  {
	private int x;
	private int y;
	private String fillColor;

	public BucketFillCommand(CommandContext ctx) throws CommandNotValidException {
		if (ctx.getParams().size() < 3) {
			throw new CommandNotValidException(
					"Fill command requires 3 parameters, " + ctx.getParams().size() + " params provided.");
		}
		this.x = Integer.parseInt(ctx.getParams().get(0));
		this.y = Integer.parseInt(ctx.getParams().get(1));
		this.fillColor = ctx.getParams().get(2);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getFillColor() {
		return fillColor;
	}


}
