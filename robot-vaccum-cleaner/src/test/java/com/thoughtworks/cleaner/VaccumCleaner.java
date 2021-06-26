/**
 * 
 */
package com.thoughtworks.cleaner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.cleaner.direction.EastDirection;
import com.thoughtworks.cleaner.direction.NorthDirection;
import com.thoughtworks.cleaner.direction.WestDirection;
import com.thoughtworks.cleaner.model.Coordinate;
import com.thoughtworks.cleaner.model.Room;
import com.thoughtworks.cleaner.model.VacuumCleaner;

/**
 * @author rohsi
 *
 */
public class VaccumCleaner {
	
	VacuumCleaner cleaner;

	@Before
	public void setUp() throws Exception {
		Coordinate roomCoordinate = new Coordinate(6,6);
		Room room = new Room(roomCoordinate);
		Coordinate vaccumCoordinate = new Coordinate(1, 2);
		NorthDirection directon =  new NorthDirection();
		cleaner = new VacuumCleaner(vaccumCoordinate, directon);
	}
	
	@Test
	public void shouldSpinLeft() {
		cleaner.left();
		assertThat(cleaner.getDirection().toString(), is("WestDirection"));
	}
	
	@Test
	public void shouldSpinRight() {
		cleaner.right();
		assertThat(cleaner.getDirection().toString(), is("EastDirection"));
	}
	
	@Test
	public void shouldMove() {
		cleaner.move();
		assertThat(cleaner.getCoordinate().getX(), is(1));
		assertThat(cleaner.getCoordinate().getY(), is(3));
	}

	

}
