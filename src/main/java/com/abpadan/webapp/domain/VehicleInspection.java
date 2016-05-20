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
import javax.validation.constraints.Size;

@Entity
public class VehicleInspection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(min = 1)
	private String inspectionDocumentNumber;
	
	private InspectionResult inspectionResult;

	private BigInteger inspectionMileage;
	
	@NotNull
	private Date inspectionDate;
	
	@NotNull
	private Date inspectionExpirationDate;

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

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

	public String getInspectionDocumentNumber() {
		return inspectionDocumentNumber;
	}

	public void setInspectionDocumentNumber(String inspectionDocumentNumber) {
		this.inspectionDocumentNumber = inspectionDocumentNumber;
	}

	public InspectionResult getInspectionResult() {
		return inspectionResult;
	}

	public void setInspectionResult(InspectionResult inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	public BigInteger getInspectionMileage() {
		return inspectionMileage;
	}

	public void setInspectionMileage(BigInteger inspectionMileage) {
		this.inspectionMileage = inspectionMileage;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public Date getInspectionExpirationDate() {
		return inspectionExpirationDate;
	}

	public void setInspectionExpirationDate(Date inspectionExpirationDate) {
		this.inspectionExpirationDate = inspectionExpirationDate;
	}
	
}
