package com.remark_herlan.hr_app.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * author: Naimul Hassan
 * 
 * date: 11/30/2024
 */

@Embeddable
public class CandidateEvaluationCompositKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "candidate_number", nullable = false)
	private Long candidateNumber;

	@Column(name = "submitted_by", nullable = false)
	private Long submittedBy;

	public Long getCandidateNumber() {
		return candidateNumber;
	}

	public Long getSubmittedBy() {
		return submittedBy;
	}

	public void setCandidateNumber(Long candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	public void setSubmittedBy(Long submittedBy) {
		this.submittedBy = submittedBy;
	}

}
