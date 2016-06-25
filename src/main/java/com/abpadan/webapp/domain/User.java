package com.abpadan.webapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(unique = true)
    private String username;
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Mechanic> mechanics = new ArrayList<Mechanic>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VehicleInspection> vehicleInspections = new ArrayList<VehicleInspection>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VehicleRegistration> vehicleRegistrations = new ArrayList<VehicleRegistration>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MaintenanceSession> maintenanceSessions = new ArrayList<MaintenanceSession>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MaintenanceActivity> maintenanceActivities = new ArrayList<MaintenanceActivity>();
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean deleteFlag;
	
	public User() {
    	
    }
    
    public User(User user) {
    	this.id = user.getId(); 
    	this.username = user.getUsername();
    	this.password = user.getPassword();
    	this.role = user.getRole();
    }
    
	public List<MaintenanceActivity> getMaintenanceActivities() {
		return maintenanceActivities;
	}

	public void setMaintenanceActivities(List<MaintenanceActivity> maintenanceActivities) {
		this.maintenanceActivities = maintenanceActivities;
	}

	public List<MaintenanceSession> getMaintenanceSessions() {
		return maintenanceSessions;
	}

	public void setMaintenanceSessions(List<MaintenanceSession> maintenanceSessions) {
		this.maintenanceSessions = maintenanceSessions;
	}

	public List<VehicleInspection> getVehicleInspections() {
		return vehicleInspections;
	}

	public void setVehicleInspections(List<VehicleInspection> vehicleInspections) {
		this.vehicleInspections = vehicleInspections;
	}

	public List<VehicleRegistration> getVehicleRegistrations() {
		return vehicleRegistrations;
	}

	public void setVehicleRegistrations(List<VehicleRegistration> vehicleRegistrations) {
		this.vehicleRegistrations = vehicleRegistrations;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Mechanic> getMechanics() {
		return mechanics;
	}

	public void setMechanics(List<Mechanic> mechanics) {
		this.mechanics = mechanics;
	}

	public long getId() {
		return id;
	}
	
    public void setId(long id) {
		this.id = id;
	}

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}