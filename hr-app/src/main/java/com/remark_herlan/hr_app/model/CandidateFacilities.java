package com.remark_herlan.hr_app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Entity
@Table(name = "candidate_facilities")
public class CandidateFacilities {

	@EmbeddedId
	private CandidateFacilitiesCompositeKey key;
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

	public CandidateFacilitiesCompositeKey getKey() {
		return key;
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

	public void setKey(CandidateFacilitiesCompositeKey key) {
		this.key = key;
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

}
