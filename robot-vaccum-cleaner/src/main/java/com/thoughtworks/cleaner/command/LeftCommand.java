/**
 * 
 */
package com.thoughtworks.cleaner.command;

import com.thoughtworks.cleaner.model.VacuumCleaner;

/**
 * @author rohsi
 *
 */
public class LeftCommand implements Command {

	public void execute(VacuumCleaner cleaner) {
		cleaner.left();
	}

}
