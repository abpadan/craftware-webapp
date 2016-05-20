package com.abpadan.webapp.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleRegistration;
import com.abpadan.webapp.repository.VehicleRegistrationRepository;

@Service
public class VehicleRegistrationService {

	@Autowired
	private VehicleRegistrationRepository vehicleRegistrationRepository;

	public List<VehicleRegistration> getVehicleRegistrationsByUser(User user) {
		return vehicleRegistrationRepository.findVehicleRegistrationsByUser(user);
	}
	
	public List<VehicleRegistration> getVehicleRegistrationsByUserAndBetweenDates(Date registrationStartDate, Date registrationEndDate, Date registrationExpirationStartDate, Date registrationExpirationEndDate, Long userID, Long vehicleID) {
		return vehicleRegistrationRepository.findVehicleRegistrationsByUserAndBetweenDates(registrationStartDate, registrationEndDate, registrationExpirationStartDate, registrationExpirationEndDate, userID, vehicleID);
	}

	public void saveVehicleRegistration(VehicleRegistration vehicleRegistration) {
		vehicleRegistrationRepository.save(vehicleRegistration);
	}

	public void deleteVehicleRegistration(long id) {
		vehicleRegistrationRepository.delete(id);
	}

	public VehicleRegistration getOne(long id) {
		return vehicleRegistrationRepository.findOne(id);
	}

	public List<VehicleRegistration> getVehicleRegistrationsByVehicleAndUser(Vehicle vehicle, User user) {
		return vehicleRegistrationRepository.findVehicleRegistrationsByVehicleAndUser(vehicle, user);
	}

}
