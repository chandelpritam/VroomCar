package com.vroomcar.VroomCar.RideNotFindException;

public class ConfictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConfictException() {

		super("Conficted entry found!!!");
	}

}
