package com.vroomcar.VroomCar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vroomcar.VroomCar.RideNotFindException.MobileNoIsNotValid;
import com.vroomcar.VroomCar.RideNotFindException.RideAlreadyPresent;
import com.vroomcar.VroomCar.RideNotFindException.RideNotFindException;
import com.vroomcar.VroomCar.Util.SmsApi;
import com.vroomcar.VroomCar.beans.Ride;

import come.vroomcar.VroomCar.service.IRideService;

@RestController
@Validated
@CrossOrigin(origins = { "http://localhost:8085" })
@RequestMapping("Rest/VroomCar")
public class RideController {
	private static final Logger LOG = LoggerFactory.getLogger(RideController.class);

	@Autowired
	IRideService rideService;

	@GetMapping(value = "sendSMS/{mobile}")
	public ResponseEntity sendSMS(@PathVariable("mobile") String mobile) throws MobileNoIsNotValid {

		if (mobile.length() != 10 && mobile.length() != 0) {
			throw new MobileNoIsNotValid();
		}
		SmsApi smsApi = new SmsApi();
		smsApi.senSMS(mobile);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/allRides", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Ride>> findAll() {

		List<Ride> list = rideService.getAllRides();
		return new ResponseEntity<List<Ride>>(list, HttpStatus.CREATED);
	}

	@GetMapping(value = "/Rides/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Ride> findByRideId(@PathVariable("id") Long rideId) {
		Ride ride = rideService.getRideById(rideId);
		return new ResponseEntity<Ride>(ride, HttpStatus.CREATED);

	}

	@PostMapping(value = "/loadRide")
	public ResponseEntity<Ride> load(@RequestBody final Ride ride) throws RideAlreadyPresent {
		LOG.info("Inside RideController createRideController method");

		System.out.println(ride);
		boolean flag = rideService.addRide(ride);
		if (flag == false) {
			System.out.println("Ride is already present");
		}
		return new ResponseEntity<Ride>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/Rides/{id}")
	public ResponseEntity<Ride> updateRideDetails(Ride ride) throws RideNotFindException {
		LOG.info("Inside RideController updateRideController method");

		boolean flag = rideService.updateRide(ride);
		if (flag == false) {
			System.out.println("Ride is Updated");
		}
		return new ResponseEntity<Ride>(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/Rides/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) throws RideNotFindException {
		LOG.info("Inside RideController deleteRideController updateRideController method");

		System.out.println(id);
		rideService.deleteRide(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
