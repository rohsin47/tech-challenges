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
public class NorthDirection implements IDirection {
	
	public void move(VacuumCleaner cleaner) {
		Coordinate newOnes = new Coordinate(cleaner.getCoordinate().getX(), cleaner.getCoordinate().getY() + 1);
		cleaner.setCoordinate(newOnes);;
		
	}

	public void left(VacuumCleaner cleaner) {
		cleaner.setDirection(new WestDirection());		
	}

	@Override
	public String toString() {
		return "NorthDirection";
	}

	public void right(VacuumCleaner cleaner) {
		cleaner.setDirection(new EastDirection());
	}

}
