package com.abpadan.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.MaintenanceSession;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleInspection;
import com.abpadan.webapp.domain.VehicleRegistration;
import com.abpadan.webapp.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleRegistrationService vehicleRegistrationService;
	
	@Autowired
	private VehicleInspectionService vehicleInspectionService;

	@Autowired
	private MaintenanceSessionService maintenanceSessionService;
	
	public List<Vehicle> getVehiclesByUser(User user) {
		return vehicleRepository.findVehiclesByUser(user);
	}
	
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	public void deleteVehicle(long id) {
		vehicleRepository.delete(id);
	}
	
	public Vehicle getOne(long id) {
		return vehicleRepository.findOne(id);
	}

	public List<Vehicle> setVehicleDeleteFlag(User user, List<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			List<VehicleRegistration> vehicleRegistrations = vehicleRegistrationService.getVehicleRegistrationsByVehicleAndUser(vehicle, user);
			List<VehicleInspection> vehicleInspections = vehicleInspectionService.getVehicleInspectionsByVehicleAndUser(vehicle, user);
			List<MaintenanceSession> maintenanceSessions = maintenanceSessionService.getMaintenanceSessionsByVehicleAndUser(vehicle, user);

			if (vehicleRegistrations.size() == 0 || vehicleInspections.size() == 0 || maintenanceSessions.size() == 0) {
				vehicle.setDeleteFlag(true);
				saveVehicle(vehicle);
			} else {
				vehicle.setDeleteFlag(false);
				saveVehicle(vehicle);
			}
		}
		return getVehiclesByUser(user);
	}
	
}
