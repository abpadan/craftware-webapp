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
public class VehicleRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private Date registrationDate;
	
	@NotNull
	private Date registrationExpirationDate;

	private BigInteger registrationMileage;
	
	@Size(min = 1)
	private String registrationDocumentNumber;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getRegistrationExpirationDate() {
		return registrationExpirationDate;
	}

	public void setRegistrationExpirationDate(Date registrationExpirationDate) {
		this.registrationExpirationDate = registrationExpirationDate;
	}

	public BigInteger getRegistrationMileage() {
		return registrationMileage;
	}

	public void setRegistrationMileage(BigInteger registrationMileage) {
		this.registrationMileage = registrationMileage;
	}

	public String getRegistrationDocumentNumber() {
		return registrationDocumentNumber;
	}

	public void setRegistrationDocumentNumber(String registrationDocumentNumber) {
		this.registrationDocumentNumber = registrationDocumentNumber;
	}

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
	
}
