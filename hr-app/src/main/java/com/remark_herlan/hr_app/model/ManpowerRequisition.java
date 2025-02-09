package com.remark_herlan.hr_app.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * author: Naimul Hassan
 * 
 * date: 2/6/2025
 */

@Entity
public class ManpowerRequisition {

	@Id
	private Long id;
	private String location;
	private String requiredPosition;
	private String numberOfEmployee;
	private String department;
	private String section;
	private String subSection;
	private String reasonForRequest;
	private Boolean isBudgeted;
	private String replacementOf;
	private String mainFunction;
	private LocalDateTime expectedJoiningDate;

	@Column(length = 1000)
	private String roleAndResponsibilities;
	private String minimumExperience;
	private String reportsTo;
	private String minimumEducation;
	private String educationPreferred;
	private String salaryRange;
	private String languageProficiency;

	@Column(length = 1000)
	private String competencyRequirements;

	@Column(length = 500)
	private String computerOperationKnowledge;

	@Column(length = 500)
	private String additionalSkills;

	private String status = "PENDING";

	@ManyToOne
	private Users createdBy;

	@CreationTimestamp
	private LocalDateTime creationDate;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public String getRequiredPosition() {
		return requiredPosition;
	}

	public String getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public String getDepartment() {
		return department;
	}

	public String getSection() {
		return section;
	}

	public String getSubSection() {
		return subSection;
	}

	public String getReasonForRequest() {
		return reasonForRequest;
	}

	public Boolean getIsBudgeted() {
		return isBudgeted;
	}

	public String getReplacementOf() {
		return replacementOf;
	}

	public String getMainFunction() {
		return mainFunction;
	}

	public LocalDateTime getExpectedJoiningDate() {
		return expectedJoiningDate;
	}

	public String getRoleAndResponsibilities() {
		return roleAndResponsibilities;
	}

	public String getMinimumExperience() {
		return minimumExperience;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public String getMinimumEducation() {
		return minimumEducation;
	}

	public String getEducationPreferred() {
		return educationPreferred;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public String getLanguageProficiency() {
		return languageProficiency;
	}

	public String getCompetencyRequirements() {
		return competencyRequirements;
	}

	public String getComputerOperationKnowledge() {
		return computerOperationKnowledge;
	}

	public String getAdditionalSkills() {
		return additionalSkills;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setRequiredPosition(String requiredPosition) {
		this.requiredPosition = requiredPosition;
	}

	public void setNumberOfEmployee(String numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public void setSubSection(String subSection) {
		this.subSection = subSection;
	}

	public void setReasonForRequest(String reasonForRequest) {
		this.reasonForRequest = reasonForRequest;
	}

	public void setIsBudgeted(Boolean isBudgeted) {
		this.isBudgeted = isBudgeted;
	}

	public void setReplacementOf(String replacementOf) {
		this.replacementOf = replacementOf;
	}

	public void setMainFunction(String mainFunction) {
		this.mainFunction = mainFunction;
	}

	public void setExpectedJoiningDate(LocalDateTime expectedJoiningDate) {
		this.expectedJoiningDate = expectedJoiningDate;
	}

	public void setRoleAndResponsibilities(String roleAndResponsibilities) {
		this.roleAndResponsibilities = roleAndResponsibilities;
	}

	public void setMinimumExperience(String minimumExperience) {
		this.minimumExperience = minimumExperience;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public void setMinimumEducation(String minimumEducation) {
		this.minimumEducation = minimumEducation;
	}

	public void setEducationPreferred(String educationPreferred) {
		this.educationPreferred = educationPreferred;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public void setLanguageProficiency(String languageProficiency) {
		this.languageProficiency = languageProficiency;
	}

	public void setCompetencyRequirements(String competencyRequirements) {
		this.competencyRequirements = competencyRequirements;
	}

	public void setComputerOperationKnowledge(String computerOperationKnowledge) {
		this.computerOperationKnowledge = computerOperationKnowledge;
	}

	public void setAdditionalSkills(String additionalSkills) {
		this.additionalSkills = additionalSkills;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
