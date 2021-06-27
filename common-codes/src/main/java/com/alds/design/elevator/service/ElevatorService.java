/**
 * 
 */
package com.alds.design.elevator.service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorDirection;
import com.alds.design.elevator.model.ElevatorStatus;

/**
 * @author rohsi
 * 
 *  	 
 *  Elevator service algorithm:
     ---------------------------
     -> It can happen that an elevator is on its way from floor 1 to floor 10 and while its is at floor 5, elevator got a pickUp request for floor 8.
        In this case, we should stop the elevator at floor 8 first and then proceed to floor 10. So a simple FCFS algorithm in elevator service queue will not work.
     -> Each elevator maintains 2 sets of floors to be serviced.
        -> 1 TreeSet for all pickUp requests from floors above the getCurrentFloor in ascending order.
        -> 1 TreeSet for all pickUp requests from floors below the getCurrentFloor in descending order.
        -> TreeSet also helps avoid duplicate requests.
     -> When an elevator moves:
        -> Case I       -> Elevator was in NONE state which means elevator hasn't serviced any request yet or was done servicing all previous requests in the direction of its move.
                        -> Start servicing the request in the direction which has closest requestFloor and set the direction as UP or DOWN based on target floor's location.
        -> Case II      -> Elevator is moving UP:
                        -> Continue to move in this direction until all requestFloors above current floors are serviced.
                        -> When done servicing all above floors, reset the direction to NONE.
        -> Case III     -> Elevator is moving DOWN:
                        -> Continue to move in this direction until all requestFloors below current floors are serviced.
                        -> When done servicing all below floors, reset the direction to NONE.
 *
 */

/*
 * Service layer responsible for floor requests pickup and consumption
 * choosing which elevator will be processing request
 * representing multi-elevator system
 */
public class ElevatorService {

	private static final int MAX_ELEVATORS = 8;

	private static final int MAX_REQUESTS = 5;

	final Elevator[] elevators;

	final int elevatorCount;

	private AtomicInteger activeRequests = new AtomicInteger();

	final ReentrantLock lock = new ReentrantLock();

	public ElevatorService(int elevatorCount) {
		this.elevatorCount = elevatorCount < MAX_ELEVATORS ? elevatorCount : MAX_ELEVATORS;
		this.elevators = new Elevator[elevatorCount];
	}

	public boolean updateStatus(ElevatorStatus elevatorStatus, int elevatorId) {
		if(elevatorId < 0 || elevatorId > elevatorCount-1){
			return false;
		}
		return elevators[elevatorId].updateStatus(elevatorStatus);
	}

	public void pickUpRequest(int floorRequest) throws InterruptedException {
		System.out.println("Pick up request received : "+floorRequest);
		lock.lock();
		try {
			int minUp = Integer.MAX_VALUE;
			Elevator minUpElevator = null;
			int minDown = Integer.MAX_VALUE;
			Elevator minDownElevator = null;

			for(Elevator elevator : elevators){

				//Don't schedule anything for given under maintenance or if elevator is already servicing more than average load on system
				if(elevator.getStatus() == ElevatorStatus.REPAIR || elevator.getTotalFloorRequests() >= MAX_REQUESTS){
					continue;
				}

				if((elevator.getDirection() == ElevatorDirection.UP
						|| elevator.getDirection() == ElevatorDirection.NONE)
						&& elevator.getCurrentFloor() < floorRequest){
					if(minUp > floorRequest - elevator.getCurrentFloor()){
						minUp = floorRequest - elevator.getCurrentFloor();
						minUpElevator = elevator;
						System.out.println("Request will be processed by elevator : "+minUpElevator.getElevatorId());
					}
				}else if((elevator.getDirection() == ElevatorDirection.DOWN
						|| elevator.getDirection() == ElevatorDirection.NONE)
						&& elevator.getCurrentFloor() > floorRequest){
					if(minDown > elevator.getCurrentFloor() - floorRequest){
						minDown = elevator.getCurrentFloor() - floorRequest;
						minDownElevator = elevator;
						System.out.println("Request will be processed by elevator : "+minDownElevator.getElevatorId());
					}
				}
			}

			//If we found 2 elevators in both up and down direction. Assign the pickUp requests to closest elevator.
			if(minDownElevator != null && minUpElevator != null){
				if(minDown < minUp){
					minDownElevator.addNewFloorRequest(floorRequest);
				}else{
					minUpElevator.addNewFloorRequest(floorRequest);
				}
			}

			//If we found only 1 closest elevator in down direction. Assign the pickUp requests to it.
			else if(minDownElevator != null){
				minDownElevator.addNewFloorRequest(floorRequest);
			}

			//If we found only 1 closest elevator in up direction. Assign the pickUp requests to it.
			else if(minUpElevator != null){
				minUpElevator.addNewFloorRequest(floorRequest);
			}

			// We could not allocate the request to any elevator. All elevators must be under maintenance. Return false.
			else{
				// do nothing
				System.out.println("Unable to serve request by any elevator");
			}
			activeRequests.getAndIncrement();
		} finally {
			lock.unlock();
		}

		Thread.sleep(2000);
	}

	public void moveElevator() throws InterruptedException {
		// Loop though every elevator and call move
		lock.lock();
		try {
			for (Elevator currElevator : elevators) {
				while (currElevator.getTotalFloorRequests() > 0)
					if (currElevator.moveAndCheckIfServed()) {
						System.out.println("Moving Elevator : "+activeRequests.get());
						activeRequests.decrementAndGet();
					}
			}
		} finally {
			lock.unlock();
		}
		Thread.sleep(2000);
	}

	public Elevator[] getElevators() {
		return elevators;
	}

	public int getElevatorCount() {
		return elevatorCount;
	}

}
