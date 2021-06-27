package com.alds.design.elevator;

import com.alds.design.elevator.controller.ElevatorController;
import com.alds.design.elevator.service.ElevatorService;

/**
 * @author rohsingh
 *
 */
public class ElevatorMain {

	public static void main(String[] args) {
		ElevatorController controller = new ElevatorController(new ElevatorService(2));
		try {
			controller.sendFloorRequest();
			controller.consumeFloorRequest();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
