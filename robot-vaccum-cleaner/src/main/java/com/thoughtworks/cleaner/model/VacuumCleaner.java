/**
 * 
 */
package com.thoughtworks.cleaner.model;

import java.util.List;

import com.thoughtworks.cleaner.command.Command;
import com.thoughtworks.cleaner.direction.Direction;
import com.thoughtworks.cleaner.direction.IDirection;

/**
 * @author rohsi
 *
 */
public class VacuumCleaner {
	
	Coordinate coordinate;
	IDirection direction;
	Room room;
	
	public void setDirection(IDirection direction) {
		this.direction = direction;
	}
	
	public VacuumCleaner(Coordinate coordinate,  IDirection direction) {
		this.coordinate = coordinate;
		this.direction = direction;
	}
	
	public void left() {
		this.direction.left(this);
	}
	
	public void right() {
		this.direction.right(this);
	}
	
	public void move() {
		this.direction.move(this);
		validate();
	}
	
	public VacuumCleaner finalState() {
		return this;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public IDirection getDirection() {
		return direction;
	}

	public Room getRoom() {
		return room;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public boolean validate() {
		return true;
	}
	
	public void execute(List<Command> commands) {
		commands.stream().forEach(command -> command.execute(this));
	}
	

}
