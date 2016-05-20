package com.abpadan.webapp.domain;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class MaintenanceSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private Date startDate;
	
	@NotNull
	private Date endDate;
	
	private BigInteger mileage;
	
	@NotNull
	private Completed completed;
	
	@NotNull
	private String activityNote;

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "mechanic_id")
	private Mechanic mechanic;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 

	@ManyToOne
	@JoinColumn(name = "maintenanceactivity_id")
	private MaintenanceActivity maintenanceActivity; 
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public Completed getCompleted() {
		return completed;
	}

	public void setCompleted(Completed completed) {
		this.completed = completed;
	}

	public String getActivityNote() {
		return activityNote;
	}

	public void setActivityNote(String activityNote) {
		this.activityNote = activityNote;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigInteger getMileage() {
		return mileage;
	}

	public void setMileage(BigInteger mileage) {
		this.mileage = mileage;
	}

	public MaintenanceActivity getMaintenanceActivity() {
		return maintenanceActivity;
	}

	public void setMaintenanceActivity(MaintenanceActivity maintenanceActivity) {
		this.maintenanceActivity = maintenanceActivity;
	}

}
