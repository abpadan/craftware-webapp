package com.abpadan.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.MaintenanceSession;
import com.abpadan.webapp.domain.Mechanic;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.repository.MechanicRepository;

@Service
public class MechanicService {

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private MaintenanceSessionService maintenanceSessionService;

	public List<Mechanic> getMechanicsByUser(User user) {
		return mechanicRepository.findMechanicsByUser(user);
	}

	public void saveMechanic(Mechanic mechanic) {
		mechanicRepository.save(mechanic);
	}

	public void deleteMechanic(long id) {
		mechanicRepository.delete(id);
	}

	public Mechanic getOne(long id) {
		return mechanicRepository.findOne(id);
	}

	public List<Mechanic> setMechanicDeleteFlag(User user, List<Mechanic> mechanics) {
		for (Mechanic mechanic : mechanics) {
			List<MaintenanceSession> mechanicMaintenanceSessions = maintenanceSessionService.getMaintenanceSessionsByMechanicAndUser(mechanic, user);
			if (mechanicMaintenanceSessions.size() == 0) {
				mechanic.setDeleteFlag(true);
				saveMechanic(mechanic);
			} else {
				mechanic.setDeleteFlag(false);
				saveMechanic(mechanic);
			}
		}
		return getMechanicsByUser(user);
	}

}
