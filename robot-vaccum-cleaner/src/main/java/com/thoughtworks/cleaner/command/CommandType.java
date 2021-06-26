/**
 * 
 */
package com.thoughtworks.cleaner.command;

/**
 * @author rohsi
 *
 */
public enum CommandType {
	
	L(new LeftCommand()),
	R(new RightCommand()),
	M(new MoveCommand());
	
	public Command command;
	
	CommandType(Command command) {
		this.command = command;
	}

}
