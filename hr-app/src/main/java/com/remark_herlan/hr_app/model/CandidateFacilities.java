package com.remark_herlan.hr_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Entity
@Table(name = "candidate_facilities")
public class CandidateFacilities {

	@Id
	private Long id;

	@Column(name = "facility_type", nullable = false)
	private String facilityType;

	private String company;
	private String sbu;
	private String department;
	private String jobGrade;
	private String reportsTo;
	private String jobLocation;
	private String designation;
	private Double salary;
	private String bonus;
	private String taOrConveyance;
	private String daOrFood;
	private String benefitOrAllowance;
	private String pfOrGratuity;
	private String transportFacility;
	private String incentiveOrKpi;
	private String mobileCeiling;
	private String totalCtc;

	@ManyToOne
	@JoinColumn(name = "candidate_numbers", nullable = false)
	private Candidates candidate;

	public Long getId() {
		return id;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public String getCompany() {
		return company;
	}

	public String getSbu() {
		return sbu;
	}

	public String getDepartment() {
		return department;
	}

	public String getJobGrade() {
		return jobGrade;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public String getDesignation() {
		return designation;
	}

	public Double getSalary() {
		return salary;
	}

	public String getBonus() {
		return bonus;
	}

	public String getTaOrConveyance() {
		return taOrConveyance;
	}

	public String getDaOrFood() {
		return daOrFood;
	}

	public String getBenefitOrAllowance() {
		return benefitOrAllowance;
	}

	public String getPfOrGratuity() {
		return pfOrGratuity;
	}

	public String getTransportFacility() {
		return transportFacility;
	}

	public String getIncentiveOrKpi() {
		return incentiveOrKpi;
	}

	public String getMobileCeiling() {
		return mobileCeiling;
	}

	public String getTotalCtc() {
		return totalCtc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setSbu(String sbu) {
		this.sbu = sbu;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setJobGrade(String jobGrade) {
		this.jobGrade = jobGrade;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public void setTaOrConveyance(String taOrConveyance) {
		this.taOrConveyance = taOrConveyance;
	}

	public void setDaOrFood(String daOrFood) {
		this.daOrFood = daOrFood;
	}

	public void setBenefitOrAllowance(String benefitOrAllowance) {
		this.benefitOrAllowance = benefitOrAllowance;
	}

	public void setPfOrGratuity(String pfOrGratuity) {
		this.pfOrGratuity = pfOrGratuity;
	}

	public void setTransportFacility(String transportFacility) {
		this.transportFacility = transportFacility;
	}

	public void setIncentiveOrKpi(String incentiveOrKpi) {
		this.incentiveOrKpi = incentiveOrKpi;
	}

	public void setMobileCeiling(String mobileCeiling) {
		this.mobileCeiling = mobileCeiling;
	}

	public void setTotalCtc(String totalCtc) {
		this.totalCtc = totalCtc;
	}

	public void setCandidate(Candidates candidate) {
		this.candidate = candidate;
	}

}
