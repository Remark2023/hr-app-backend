package com.remark_herlan.hr_app.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * author: Naimul Hassan
 * 
 * date: 11/30/2024
 */

@Entity
public class CandidateExperiences {

	@Id
	private Long id;
	private String experienceField;
	private String organization;
	private String years;
	
	@ManyToOne
	@JoinColumn(name = "candidate_number", nullable = false)
	private Candidates candidate;

	public Long getId() {
		return id;
	}

	public String getExperienceField() {
		return experienceField;
	}

	public String getOrganization() {
		return organization;
	}

	public String getYears() {
		return years;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setExperienceField(String experienceField) {
		this.experienceField = experienceField;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setYears(String years) {
		this.years = years;
	}

}
