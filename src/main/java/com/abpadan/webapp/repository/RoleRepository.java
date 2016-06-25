package com.abpadan.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abpadan.webapp.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query(value = "SELECT * FROM role", nativeQuery = true)
	List<Role> findRoles();
	
	Role findRoleByName(String name);
	
}
