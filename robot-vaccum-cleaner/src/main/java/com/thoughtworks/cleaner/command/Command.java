/**
 * 
 */
package com.thoughtworks.cleaner.command;

import com.thoughtworks.cleaner.model.VacuumCleaner;

/**
 * @author rohsi
 *
 */
public interface Command {
	
	void execute(VacuumCleaner cleaner);

}
