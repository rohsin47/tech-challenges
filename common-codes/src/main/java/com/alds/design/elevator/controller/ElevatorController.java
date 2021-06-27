package com.alds.design.elevator.controller;


import java.util.concurrent.ThreadLocalRandom;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.service.ElevatorService;

/**
 * @author rohsingh
 * 
 * 
 *         
 *  Scheduling Algorithm:
    ---------------------------
    -> Upper bound of active requests per elevator (Average per elevator) = activeRequests/elevatorCount + 1
    -> Do not assign the request to an elevator if it is under MAINTENANCE or is already serving more than average number of active requests in the system.
    -> Now, among all elevators excluding above ones, find the closest elevator moving in direction of request or is IDLE.
        -> Case I -     There are 2 elevators - 1 above the requestFloor coming down and 1 below the requestFloor which is coming up:
                        Assign the request to the closest of these 2.
                        return true
        -> Case II -    There is only 1 elevator moving towards the requestFloor:
                        Assign the request to the given elevator.
                        return true
        -> Case III -   No elevators were found eligible to serve the request. Can happen if all the elevators are under MAINTENANCE
                        return false as we could not schedule the request to any of the elevators in the system.
 */
public class ElevatorController {

	ElevatorService elevatorService;

	public ElevatorController(ElevatorService elevatorService) {
		this.elevatorService = elevatorService;
		boot();
	}

	private void boot() {
		System.out.println("Elevator System starting..");
		int elevatorCount = elevatorService.getElevatorCount();
		Elevator[] elevators = elevatorService.getElevators();
		for (int elevator = 0; elevator < elevatorCount; elevator++) {
			elevators[elevator] = new Elevator(elevator, 0);
			System.out.println("Started Elevator " + elevators[elevator].getElevatorId());
		}
		System.out.println("Elevator System started..");
	}
	
	public void sendFloorRequest() throws InterruptedException {	
		new Thread(() ->  {
			while(true) {
				try {
					elevatorService.pickUpRequest(ThreadLocalRandom.current().nextInt(10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void consumeFloorRequest() throws InterruptedException {
		new Thread(() ->  {
			while(true) {
				try {
					elevatorService.moveElevator();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
