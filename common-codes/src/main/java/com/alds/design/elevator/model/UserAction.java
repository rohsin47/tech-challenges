package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public class UserAction {
	
	private int userId;
	private ElevatorDirection direction;
	private int level;
	private int elevatorId;
	
	public UserAction(ElevatorDirection direction, int level, int elevatorId) {
		super();
		this.direction = direction;
		this.level = level;
		this.elevatorId = elevatorId;
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

	public int getLevel() {
		return level;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getElevatorId() {
		return elevatorId;
	}
}
