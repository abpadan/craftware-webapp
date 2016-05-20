package com.abpadan.webapp.domain;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(min = 1)
	private String make;
	
	@Size(min = 1)
	private String model;

	private BigInteger year;
	
	@Size(min = 1)
	private String color;
	
	@Size(min = 1)
	private String licensePlateNumber;
	
	@Size(min = 1)
	private String DOTNumber;

	@NotNull
	private Date purchaseDate;
	
	@NotNull
	private BigInteger purchaseMileage;
	
	@NotNull
	private Status status;
	
	private BigInteger vehicleMaintenanceSessionCount;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean deleteFlag; 
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<MaintenanceSession> maintenanceSessions; 
	
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<VehicleInspection> vehicleInspectionSessions; 

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<VehicleRegistration> vehicleRegistrationSessions; 
	
	public List<VehicleRegistration> getVehicleRegistrationSessions() {
		return vehicleRegistrationSessions;
	}

	public void setVehicleRegistrationSessions(List<VehicleRegistration> vehicleRegistrationSessions) {
		this.vehicleRegistrationSessions = vehicleRegistrationSessions;
	}

	public List<MaintenanceSession> getMaintenanceSessions() {
		return maintenanceSessions;
	}

	public void setMaintenanceSessions(List<MaintenanceSession> maintenanceSessions) {
		this.maintenanceSessions = maintenanceSessions;
	}

	public List<VehicleInspection> getVehicleInspectionSessions() {
		return vehicleInspectionSessions;
	}

	public void setVehicleInspectionSessions(List<VehicleInspection> vehicleInspectionSessions) {
		this.vehicleInspectionSessions = vehicleInspectionSessions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigInteger getYear() {
		return year;
	}

	public void setYear(BigInteger year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getDOTNumber() {
		return DOTNumber;
	}

	public void setDOTNumber(String dOTNumber) {
		DOTNumber = dOTNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigInteger getPurchaseMileage() {
		return purchaseMileage;
	}

	public void setPurchaseMileage(BigInteger purchaseMileage) {
		this.purchaseMileage = purchaseMileage;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public BigInteger getVehicleMaintenanceSessionCount() {
		return vehicleMaintenanceSessionCount;
	}

	public void setVehicleMaintenanceSessionCount(Vehicle vehicle) {
		this.vehicleMaintenanceSessionCount = BigInteger.valueOf(vehicle.getMaintenanceSessions().size());
	}

}
