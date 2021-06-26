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
public class WestDirection implements IDirection {

	public void move(VacuumCleaner cleaner) {
		cleaner.setCoordinate(new Coordinate(cleaner.getCoordinate().getX(), cleaner.getCoordinate().getY() + 1));
		
	}

	public void left(VacuumCleaner cleaner) {
		cleaner.setDirection(new NorthDirection());
		
	}

	@Override
	public String toString() {
		return "WestDirection";
	}

	public void right(VacuumCleaner cleaner) {
		cleaner.setDirection(new SouthDirection());
	}

}
