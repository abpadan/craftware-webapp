package com.abpadan.webapp.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleRegistration;

public interface VehicleRegistrationRepository extends JpaRepository<VehicleRegistration, Long> {

	List<VehicleRegistration> findVehicleRegistrationsByUser(User user);
	
	List<VehicleRegistration> findVehicleRegistrationsByVehicleAndUser(Vehicle vehicle, User user);
	
	@Query(value = "SELECT * FROM vehicle_registration vr WHERE vr.registration_date BETWEEN :registrationStartDate AND :registrationEndDate AND vr.registration_expiration_date BETWEEN :registrationExpirationStartDate AND :registrationExpirationEndDate AND vr.user_id = :userID AND vr.vehicle_id = :vehicleID", nativeQuery = true)
	List<VehicleRegistration> findVehicleRegistrationsByUserAndBetweenDates(
			@Param("registrationStartDate") Date registrationStartDate,
			@Param("registrationEndDate") Date registrationEndDate,
			@Param("registrationExpirationStartDate") Date registrationExpirationStartDate,
			@Param("registrationExpirationEndDate") Date registrationExpirationEndDate, 
			@Param("userID") long userID, @Param("vehicleID") long vehicleID);

}
