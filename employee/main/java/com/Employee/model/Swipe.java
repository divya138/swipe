package com.Employee.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Swipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long swipeId;

	private String swipeIn;

	private String swipeOut;
	@Temporal(TemporalType.DATE)
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private double hoursPerFacility;

	public double getHoursPerFacility() {
		return hoursPerFacility;
	}

	public void setHoursPerFacility(double hoursPerFacility) {
		this.hoursPerFacility = hoursPerFacility;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	private Facility facility;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private Employee employee;

	public Long getSwipeId() {
		return swipeId;
	}

	public void setSwipeId(Long swipeId) {
		this.swipeId = swipeId;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getSwipeIn() {
		return swipeIn;
	}

	public void setSwipeIn(String swipeIn) {
		this.swipeIn = swipeIn;
	}

	public String getSwipeOut() {
		return swipeOut;
	}

	public void setSwipeOut(String swipeOut) {
		this.swipeOut = swipeOut;
	}

}