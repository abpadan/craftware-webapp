package com.abpadan.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abpadan.webapp.domain.MaintenanceActivity;
import com.abpadan.webapp.domain.User;

public interface MaintenanceActivityRepository extends JpaRepository<MaintenanceActivity, Long> {

	List<MaintenanceActivity> findMaintenanceActivitiesByUser(User user);

}
