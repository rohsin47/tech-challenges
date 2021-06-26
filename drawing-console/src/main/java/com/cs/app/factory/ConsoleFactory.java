/**
 * 
 */
package com.cs.app.factory;

import com.cs.app.util.ConsoleConstants;

/**
 * @author rohsi
 *
 */
public class ConsoleFactory {
	
	public static AbstractFactory getFactory(String type) {	
		if(ConsoleConstants.COMMAND.equals(type)) {
			return new CommandFactory();
		}
		
		if(ConsoleConstants.CANVAS.equals(type)) {
			return new CanvasFactory();
		}
		
		if(ConsoleConstants.SHAPE.equals(type)) {
			return new ShapeFactory();
		}	
		return null;
	}
}
