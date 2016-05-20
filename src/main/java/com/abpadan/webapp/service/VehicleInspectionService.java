package com.abpadan.webapp.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleInspection;
import com.abpadan.webapp.repository.VehicleInspectionRepository;

@Service
public class VehicleInspectionService {

	@Autowired
	private VehicleInspectionRepository vehicleInspectionRepository;

	public List<VehicleInspection> getVehicleInspectionsByUser(User user) {
		return vehicleInspectionRepository.findVehicleInspectionsByUser(user);
	}

	public void saveVehicleInspection(VehicleInspection vehicleInspection) {
		vehicleInspectionRepository.save(vehicleInspection);
	}

	public void deleteVehicleInspection(long id) {
		vehicleInspectionRepository.delete(id);
	}

	public VehicleInspection getOne(long id) {
		return vehicleInspectionRepository.findOne(id);
	}

	public List<VehicleInspection> getVehicleInspectionsByVehicleAndUser(Vehicle vehicle, User user) {
		return vehicleInspectionRepository.findVehicleInspectionsByVehicleAndUser(vehicle, user);
	}

	public List<VehicleInspection> getVehicleInspectionsByUserAndBetweenDates(Date inspectionStartDate,
			Date inspectionEndDate, Date inspectionExpirationStartDate, Date inspectionExpirationEndDate, long userID,
			long vehicleID) {
		return vehicleInspectionRepository.findVehicleInspectionsByUserAndBetweenDates(inspectionStartDate, inspectionEndDate, inspectionExpirationStartDate, inspectionExpirationEndDate, userID, vehicleID);
	}

}
