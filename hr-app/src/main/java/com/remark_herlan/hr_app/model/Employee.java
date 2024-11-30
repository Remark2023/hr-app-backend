package com.remark_herlan.hr_app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * author: Naimul Hassan 
 * 
 * date: 11/30/2024
 */

@Entity
public class Employee {

	@Id
	private String employeeId;
	private String fullName;
	private String channel;
	private String designation;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	@OneToOne
	private Users user;

	public String getEmployeeId() {
		return employeeId;
	}

	public String getFullName() {
		return fullName;
	}

	public String getChannel() {
		return channel;
	}

	public String getDesignation() {
		return designation;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public Users getUser() {
		return user;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
