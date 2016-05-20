package com.abpadan.webapp.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abpadan.webapp.domain.MaintenanceActivity;
import com.abpadan.webapp.domain.MaintenanceSession;
import com.abpadan.webapp.domain.Mechanic;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;

public interface MaintenanceSessionRepository extends JpaRepository<MaintenanceSession, Long> {

	List<MaintenanceSession> findMaintenanceSessionsByUser(User user);
	
	List<MaintenanceSession> findMaintenanceSessionsByMechanicAndUser(Mechanic mechanic, User user);
	
	List<MaintenanceSession> findMaintenanceSessionsByMaintenanceActivityAndUser(MaintenanceActivity maintenanceActivity, User user);
	
	List<MaintenanceSession> findMaintenanceSessionsByVehicleAndUser(Vehicle vehicle, User user);
	
	@Query(value = "SELECT * FROM maintenance_session ms WHERE ms.start_date BETWEEN :startDate AND :endDate AND ms.end_date BETWEEN :startDate AND :endDate AND ms.user_id = :userID AND ms.vehicle_id = :vehicleID AND ms.mechanic_id = :mechanicID AND ms.maintenanceactivity_id = :maintenanceActivityID", nativeQuery = true)
	List<MaintenanceSession> findMaintenanceSessionsByUserAndVehicleAndMechanicAndMaintenanceActivityAndBetweenDates(
			@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("userID") long userID,
			@Param("vehicleID") long vehicleID, @Param("mechanicID") long mechanicID,
			@Param("maintenanceActivityID") long maintenanceActivityID);

}
