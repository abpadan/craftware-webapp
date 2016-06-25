package com.abpadan.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abpadan.webapp.domain.Role;
import com.abpadan.webapp.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAllRoles() {
		return roleRepository.findRoles();
	}
	
	public Role getRoleByName(String name) {
		return roleRepository.findRoleByName(name);
	}

}
