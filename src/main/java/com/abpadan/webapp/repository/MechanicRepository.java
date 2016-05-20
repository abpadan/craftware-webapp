package com.abpadan.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abpadan.webapp.domain.Mechanic;
import com.abpadan.webapp.domain.User;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

	List<Mechanic> findMechanicsByUser(User user);

}
