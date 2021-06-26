/**
 * 
 */
package com.thoughtworks.cleaner.direction;

import com.thoughtworks.cleaner.model.Coordinate;
import com.thoughtworks.cleaner.model.VacuumCleaner;

/**
 * @author rohsi
 *
 */
public class SouthDirection implements IDirection {

	public void move(VacuumCleaner cleaner) {
		cleaner.setCoordinate(new Coordinate(cleaner.getCoordinate().getX(), cleaner.getCoordinate().getY() + 1));	
	}

	@Override
	public String toString() {
		return "SouthDirection";
	}

	public void left(VacuumCleaner cleaner) {
		cleaner.setDirection(new NorthDirection());
		
	}

	public void right(VacuumCleaner cleaner) {
		cleaner.setDirection(new SouthDirection());
	}
}
