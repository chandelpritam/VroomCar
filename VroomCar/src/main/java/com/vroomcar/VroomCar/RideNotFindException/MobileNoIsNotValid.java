package com.vroomcar.VroomCar.RideNotFindException;

import java.util.regex.Pattern;

import ch.qos.logback.core.boolex.Matcher;

public class MobileNoIsNotValid extends Exception {
	public MobileNoIsNotValid() {
		super("Please enter valid mobile number !");
	}
}
