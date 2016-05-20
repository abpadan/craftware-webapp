package com.abpadan.webapp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.MaintenanceActivity;
import com.abpadan.webapp.domain.MaintenanceSession;
import com.abpadan.webapp.domain.Mechanic;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleInspection;
import com.abpadan.webapp.domain.VehicleRegistration;
import com.abpadan.webapp.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MaintenanceSessionService maintenanceSessionService;
	
	@Autowired
	private MaintenanceActivityService maintenanceActivityService;
	
	@Autowired
	private VehicleRegistrationService vehicleRegistrationService;
		
	@Autowired
	private VehicleInspectionService vehicleInspectionService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private MechanicService mechanicService;
	
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
    	return userRepository.findAll();
    }
    
    public LocalDate formatDate(String date, String format) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    	LocalDate localDate = LocalDate.parse(date, formatter);
    	return localDate;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		} 
		
		return new UserRepositoryUserDetails(user);
	}
	
	public void deleteUser(long id) {
		User user = getOne(id);
		
		List<MaintenanceSession> maintenanceSessions = maintenanceSessionService.getMaintenaceSessionsByUser(user);
		for (MaintenanceSession maintenanceSession : maintenanceSessions) {
			maintenanceSessionService.deleteMaintenanceSession(maintenanceSession.getId());
		}
		
		List<MaintenanceActivity> maintenanceActivities = maintenanceActivityService.getMaintenanceActivitiesByUser(user);
		for (MaintenanceActivity maintenanceActivity : maintenanceActivities) {
			maintenanceActivityService.deleteMaintenanceActivity(maintenanceActivity.getId());;
		}
		
		List<VehicleRegistration> vehicleRegistrations = vehicleRegistrationService.getVehicleRegistrationsByUser(user);
		for (VehicleRegistration vehicleRegistration : vehicleRegistrations) {
			vehicleRegistrationService.deleteVehicleRegistration(vehicleRegistration.getId());
		}
		
		List<VehicleInspection> vehicleInspections = vehicleInspectionService.getVehicleInspectionsByUser(user);
		for (VehicleInspection vehicleInspection : vehicleInspections) {
			vehicleInspectionService.deleteVehicleInspection(vehicleInspection.getId());
		}
		
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		for (Vehicle vehicle : vehicles) {
			vehicleService.deleteVehicle(vehicle.getId());;
		}
		
		List<Mechanic> mechanics = mechanicService.getMechanicsByUser(user);
		for (Mechanic mechanic : mechanics) {
			mechanicService.deleteMechanic(mechanic.getId());
		}
		
		userRepository.delete(id);
	}

	public User getOne(long id) {
		return userRepository.findOne(id);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public List<User> setUserDeleteFlag(User currentUser, List<User> users) {
		for (User user : users) {
			if (user.getUsername().equals(currentUser.getUsername())) {
				user.setDeleteFlag(false);
				saveUser(user);
			} else {
				user.setDeleteFlag(true);
				saveUser(user);
			}
		}
		return getAllUsers();
	}
	
}
