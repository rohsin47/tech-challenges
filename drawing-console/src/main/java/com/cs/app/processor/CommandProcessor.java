package com.cs.app.processor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cs.app.command.AbstractCanvasCommand;
import com.cs.app.command.AbstractShapeCommand;
import com.cs.app.command.context.Command;
import com.cs.app.command.context.CommandContext;
import com.cs.app.exception.CommandNotValidException;
import com.cs.app.exception.MissingCanvasException;
import com.cs.app.factory.CanvasFactory;
import com.cs.app.factory.CommandFactory;
import com.cs.app.factory.CommandType;
import com.cs.app.factory.ConsoleFactory;
import com.cs.app.factory.ShapeFactory;
import com.cs.app.model.ICanvas;
import com.cs.app.model.Shape;
import com.cs.app.util.ConsoleConstants;


/**
 * @author rohsingh
 *
 */
public class CommandProcessor {
     
    private ICanvas canvas;  
    
    private CommandFactory commandFactory;
    private ShapeFactory shapeFactory;
    private CanvasFactory canvasFactory;   
    
    public CommandProcessor(){
        this.commandFactory = (CommandFactory) ConsoleFactory.getFactory(ConsoleConstants.COMMAND);
        this.shapeFactory = (ShapeFactory) ConsoleFactory.getFactory(ConsoleConstants.SHAPE);
        this.canvasFactory = (CanvasFactory) ConsoleFactory.getFactory(ConsoleConstants.CANVAS);
    }
    
    public void processCommand(String input) {
    	Command command; 	
    	try {
	        if(validateCommand(input)) {
	            CommandContext commandCtx = new CommandContext(input);
	        	command = commandFactory.getCommand(commandCtx);
	            if (command instanceof AbstractCanvasCommand) {
	                canvas = canvasFactory.getCanvas(command);
	                ((AbstractCanvasCommand) command).setCanvas(canvas);
	            }
	
	            if (command instanceof AbstractShapeCommand) {
	            	if(canvas == null) {
	            		throw new MissingCanvasException("Canvas is required for the command. Please create a canvas first.");
	            	}     	
	            	Shape shape = shapeFactory.getShape(command);
	            	((AbstractShapeCommand) command).setCanvas(canvas);
	            	((AbstractShapeCommand) command).setShape(shape);
	            }
	            command.execute();
	        } else {
	        	throw new CommandNotValidException("Command is not valid for processing, please input valid command.");
	        }
    	} catch (CommandNotValidException | MissingCanvasException e) {
            System.err.println(e.getMessage());		
    	}
    }
    
    
    protected boolean validateCommand(String commandInput) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+");
        Matcher matcher = pattern.matcher(commandInput);
        if (!matcher.matches()) {
           return false;
        }
        
        String commandPart = commandInput.substring(0, 1);
        if (null == CommandType.resolveCommand(commandPart)) {
            return false;
        }
        return true;
    }
    
}
