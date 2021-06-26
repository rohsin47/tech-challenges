package com.cs.app.factory;

import com.cs.app.command.CreateCanvasCommand;
import com.cs.app.command.BucketFillCommand;
import com.cs.app.command.DrawLineCommand;
import com.cs.app.command.QuitCommand;
import com.cs.app.command.DrawRectangleCommand;
import com.cs.app.command.context.Command;
import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;

/**
 * @author rohsingh
 *
 */
public class CommandFactory implements AbstractFactory {

    public Command getCommand(CommandContext ctx) throws CommandNotValidException {      
        switch (ctx.getCommand()) {
        case CANVAS:    return new CreateCanvasCommand(ctx);
        case LINE:      return new DrawLineCommand(ctx);
        case RECTANGLE: return new DrawRectangleCommand(ctx);
        case FILL:      return new BucketFillCommand(ctx);
        case QUIT:      return new QuitCommand();
        default:
            throw new CommandNotValidException("Invalid command!");
        }
    }

}
