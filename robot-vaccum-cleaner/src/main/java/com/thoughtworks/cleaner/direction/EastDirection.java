/**
 * 
 */
package com.thoughtworks.cleaner.direction;

import com.thoughtworks.cleaner.model.VacuumCleaner;

/**
 * @author rohsi
 *
 */
public class EastDirection implements IDirection {

	@Override
	public String toString() {
		return "EastDirection";
	}

	public void move(VacuumCleaner cleaner) {
		cleaner.getCoordinate().newCoordinate(cleaner.getCoordinate().getX() + 1, cleaner.getCoordinate().getY());
		
	}

	public void left(VacuumCleaner cleaner) {
		cleaner.setDirection(new NorthDirection());
		
	}

	public void right(VacuumCleaner cleaner) {
		cleaner.setDirection(new EastDirection());
	}

}
