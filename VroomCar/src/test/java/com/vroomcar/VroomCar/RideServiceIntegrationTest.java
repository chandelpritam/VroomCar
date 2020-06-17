package com.vroomcar.VroomCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vroomcar.VroomCar.Repository.RideRepository;
import com.vroomcar.VroomCar.beans.Ride;
import com.vroomcar.VroomCar.serviceImpl.RideService;

@RunWith(SpringRunner.class)
public class RideServiceIntegrationTest {

	@TestConfiguration
	static class TestContextConfiguration {

		@Bean
		public RideService rideService() {
			return new RideService();
		}
	}

	Long rideid;
	@Autowired
	private RideService rideService;

	@MockBean
	private RideRepository rideRepository;

	@Before
	public void setUp() {
		Ride ride = new Ride();
		ride.setRideid(rideid);
		Mockito.when(rideRepository.findById(ride.getRideid())).thenReturn(ride);
	}

	@Test
	public void whenValid_thenRideShouldbeFound() {
		String id = "2";
		Ride found = rideService.getRideById(rideid);
		assertThat(found.getRideid()).isEqualTo(rideid);
	}

}
