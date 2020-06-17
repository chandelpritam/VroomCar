package come.vroomcar.VroomCar.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vroomcar.VroomCar.RideNotFindException.RideAlreadyPresent;
import com.vroomcar.VroomCar.RideNotFindException.RideNotFindException;
import com.vroomcar.VroomCar.beans.Ride;

@Component
public interface IRideService {
	List<Ride> getAllRides();

	Ride getRideById(long rideId);

	boolean addRide(Ride ride) throws RideAlreadyPresent;

	boolean updateRide(Ride ride) throws RideNotFindException;

	void deleteRide(long rideId)throws RideNotFindException;

}
