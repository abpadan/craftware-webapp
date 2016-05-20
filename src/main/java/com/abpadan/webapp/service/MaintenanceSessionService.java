package com.abpadan.webapp.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.MaintenanceActivity;
import com.abpadan.webapp.domain.MaintenanceSession;
import com.abpadan.webapp.domain.Mechanic;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.repository.MaintenanceSessionRepository;

@Service
public class MaintenanceSessionService {

	@Autowired
	private MaintenanceSessionRepository maintenaceSessionRepository;

	public List<MaintenanceSession> getMaintenaceSessionsByUser(User user) {
		return maintenaceSessionRepository.findMaintenanceSessionsByUser(user);
	}

	public List<MaintenanceSession> getMaintenanceSessionsByMechanicAndUser(Mechanic mechanic, User user) {
		return maintenaceSessionRepository.findMaintenanceSessionsByMechanicAndUser(mechanic, user);
	}
	
	public List<MaintenanceSession> getMaintenanceSessionsByMaintenanceActivityAndUser(MaintenanceActivity maintenanceActivity, User user) {
		return maintenaceSessionRepository.findMaintenanceSessionsByMaintenanceActivityAndUser(maintenanceActivity, user);
	}
	
	public List<MaintenanceSession> getMaintenanceSessionsByVehicleAndUser(Vehicle vehicle, User user) {
		return maintenaceSessionRepository.findMaintenanceSessionsByVehicleAndUser(vehicle, user);
	}
	
	public void saveMaintenanceSession(MaintenanceSession maintenanceSession) {
		maintenaceSessionRepository.save(maintenanceSession);
	}

	public void deleteMaintenanceSession(long id) {
		maintenaceSessionRepository.delete(id);
	}

	public MaintenanceSession getOne(long id) {
		return maintenaceSessionRepository.findOne(id);
	}

	public List<MaintenanceSession> getMaintenanceSessionsByUserAndVehicleAndMechanicAndMaintenanceActivityAndBetweenDates(
			Date startDate, Date endDate, long userID, long vehicleID, long mechanicID, long maintenanceActivityID) {
		return maintenaceSessionRepository.findMaintenanceSessionsByUserAndVehicleAndMechanicAndMaintenanceActivityAndBetweenDates(startDate,
						endDate, userID, vehicleID, mechanicID, maintenanceActivityID);
	}

}
