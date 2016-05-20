package com.abpadan.webapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
public class Mechanic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(min = 1)
	private String firstName;

	@Size(min = 1)
	private String lastName;

	@Size(min = 6)
	private String phoneNumber;

	@Size(min = 3)
	private String email;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean deleteFlag; 
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<MaintenanceSession> maintenanceSessions = new ArrayList<MaintenanceSession>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<MaintenanceSession> getMaintenanceSessions() {
		return maintenanceSessions;
	}

	public void setMaintenanceSessions(List<MaintenanceSession> maintenanceSessions) {
		this.maintenanceSessions = maintenanceSessions;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
