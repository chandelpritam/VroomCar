/**
 * 
 */
package com.vroomcar.VroomCar.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vroomcar.VroomCar.Repository.RideRepository;
import com.vroomcar.VroomCar.RideNotFindException.RideAlreadyPresent;
import com.vroomcar.VroomCar.RideNotFindException.RideNotFindException;
import com.vroomcar.VroomCar.beans.Ride;

import come.vroomcar.VroomCar.service.IRideService;

/**
 * @author swatibawankule Service class to implement Ride related logics
 *
 */
@Component
public class RideService implements IRideService {
	private static final Logger LOG = LoggerFactory.getLogger(RideService.class);

	@Autowired
	RideRepository rideRepository;

//	ArrayList<Ride> rideList = new ArrayList<Ride>();

	@Override
	public List<Ride> getAllRides() {
		ArrayList<Ride> rideList = (ArrayList<Ride>) rideRepository.findAll();
		LOG.info("List of Ride details:{} ", rideList);

		return rideList;
	}

	@Override
	public Ride getRideById(long rideId) {
		return null;

	}

	@Override
	public boolean addRide(Ride ride) throws RideAlreadyPresent {
		rideRepository.save(ride);
		return true;
	}

	@Override
	public boolean updateRide(Ride ride) throws RideNotFindException {
		rideRepository.save(ride);
		return true;
	}

	@Override
	public void deleteRide(long rideId) throws RideNotFindException {
		// getRideById if trturns true then delete tht ride

		rideRepository.deleteById(rideId);

		// else throw new RideNotFindException;
	}

}
