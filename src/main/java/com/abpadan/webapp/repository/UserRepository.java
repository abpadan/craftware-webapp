package com.abpadan.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abpadan.webapp.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);

}
