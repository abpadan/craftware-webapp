package com.abpadan.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findVehiclesByUser(User user);

}
