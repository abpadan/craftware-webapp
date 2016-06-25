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
public class MaintenanceActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Size(min = 1)
	private String activityName;
	
	@OneToMany(mappedBy = "maintenanceActivity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MaintenanceSession> maintenanceSessions = new ArrayList<MaintenanceSession>();

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean deleteFlag;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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
