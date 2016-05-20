package com.abpadan.webapp.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleInspection;

public interface VehicleInspectionRepository extends JpaRepository<VehicleInspection, Long> {

	List<VehicleInspection> findVehicleInspectionsByUser(User user);

	List<VehicleInspection> findVehicleInspectionsByVehicleAndUser(Vehicle vehicle, User user);

	@Query(value = "SELECT * FROM vehicle_inspection vi WHERE vi.inspection_date BETWEEN :inspectionStartDate AND :inspectionEndDate AND vi.inspection_expiration_date BETWEEN :inspectionExpirationStartDate AND :inspectionExpirationEndDate AND vr.user_id = :userID AND vr.vehicle_id = :vehicleID", nativeQuery = true)
	List<VehicleInspection> findVehicleInspectionsByUserAndBetweenDates(
			@Param("inspectionStartDate") Date inspectionStartDate, @Param("inspectionEndDate") Date inspectionEndDate,
			@Param("inspectionExpirationStartDate") Date inspectionExpirationStartDate,
			@Param("inspectionExpirationEndDate") Date inspectionExpirationEndDate, @Param("userID") long userID,
			@Param("vehicleID") long vehicleID);

}
