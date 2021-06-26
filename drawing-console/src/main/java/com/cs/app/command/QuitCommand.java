package com.cs.app.command;

import com.cs.app.command.context.Command;

/**
 * @author rohsingh
 *
 */
public class QuitCommand implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}

}
