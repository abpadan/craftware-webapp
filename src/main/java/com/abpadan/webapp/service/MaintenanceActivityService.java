package com.abpadan.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.MaintenanceActivity;
import com.abpadan.webapp.domain.MaintenanceSession;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.repository.MaintenanceActivityRepository;

@Service
public class MaintenanceActivityService {
	
	@Autowired
	private MaintenanceActivityRepository maintenanceActivityRepository;
	
	@Autowired
	private MaintenanceSessionService maintenanceSessionService;
	
	public List<MaintenanceActivity> getMaintenanceActivitiesByUser(User user) {
		return maintenanceActivityRepository.findMaintenanceActivitiesByUser(user);
	}
	
	public void saveMaintenanceActivity(MaintenanceActivity maintenanceActivity) {
		maintenanceActivityRepository.save(maintenanceActivity);
	}
	
	public void deleteMaintenanceActivity(long id) {
		maintenanceActivityRepository.delete(id);
	}
	
	public MaintenanceActivity getOne(long id) {
		return maintenanceActivityRepository.findOne(id);
	}

	public List<MaintenanceActivity> setMaintenanceActivityDeleteFlag(User user, List<MaintenanceActivity> maintenanceActivities) {
		for (MaintenanceActivity maintenanceActivity : maintenanceActivities) {
			List<MaintenanceSession> mechanicMaintenanceSessions = maintenanceSessionService.getMaintenanceSessionsByMaintenanceActivityAndUser(maintenanceActivity, user);
			if (mechanicMaintenanceSessions.size() == 0) {
				maintenanceActivity.setDeleteFlag(true);
				saveMaintenanceActivity(maintenanceActivity);
			} else {
				maintenanceActivity.setDeleteFlag(false);
				saveMaintenanceActivity(maintenanceActivity);
			}
		}
		return getMaintenanceActivitiesByUser(user);
	}
	
}
