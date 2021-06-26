/**
 * 
 */
package com.thoughtworks.cleaner.command;

import com.thoughtworks.cleaner.model.VacuumCleaner;

/**
 * @author rohsi
 *
 */
public class RightCommand implements Command {

	public void execute(VacuumCleaner cleaner) {
		cleaner.right();
	}

}
