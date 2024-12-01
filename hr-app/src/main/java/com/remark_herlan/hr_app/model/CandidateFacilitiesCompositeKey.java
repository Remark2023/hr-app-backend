package com.remark_herlan.hr_app.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Embeddable
public class CandidateFacilitiesCompositeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "candidate_numbers", nullable = false)
	private Long candidateNumbers;

	@Column(name = "facility_type", nullable = false)
	private String facilityType;

	public Long getCandidateNumbers() {
		return candidateNumbers;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setCandidateNumbers(Long candidateNumbers) {
		this.candidateNumbers = candidateNumbers;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

}
