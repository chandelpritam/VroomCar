package com.vroomcar.VroomCar.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.vroomcar.VroomCar.beans.Ride;

@Component
public interface RideRepository extends CrudRepository<Ride, Long> {

	public Ride findByRideid(Long rideid);

}