package com.vroomcar.VroomCar.RideNotFindException;

public class RideAlreadyPresent extends Exception {
	public RideAlreadyPresent() {
		super("Ride is already present !");
	}
}
