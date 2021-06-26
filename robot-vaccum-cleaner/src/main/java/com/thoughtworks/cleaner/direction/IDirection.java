/**
 * 
 */
package com.thoughtworks.cleaner.direction;

import com.thoughtworks.cleaner.model.VacuumCleaner;

/**
 * @author rohsi
 *
 */
public interface IDirection {
	
	void left(VacuumCleaner cleaner);
	
	void right(VacuumCleaner cleaner);
	
	void move(VacuumCleaner cleaner);

}
