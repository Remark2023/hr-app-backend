package com.remark_herlan.hr_app.model;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * author: Naimul Hassan
 * 
 * date: 11/30/2024
 */

@Entity
@Table(name = "candidate_evaluation")
public class CandidateEvaluation {

	@EmbeddedId
	private CandidateEvaluationCompositKey key;
	private LocalDateTime submittedDate;
	private Double attireBodyLanguage;
	private Double workKnowledge;
	private Double teamPlayer;
	private Double problemSolvingSkill;
	private Double communicationSkill;
	private Double outOfMarks;
	private Double totalMarks;
	private Double avgMarks;
	private String performance;

	public CandidateEvaluationCompositKey getKey() {
		return key;
	}

	public LocalDateTime getSubmittedDate() {
		return submittedDate;
	}

	public Double getAttireBodyLanguage() {
		return attireBodyLanguage;
	}

	public Double getWorkKnowledge() {
		return workKnowledge;
	}

	public Double getTeamPlayer() {
		return teamPlayer;
	}

	public Double getProblemSolvingSkill() {
		return problemSolvingSkill;
	}

	public Double getCommunicationSkill() {
		return communicationSkill;
	}

	public Double getOutOfMarks() {
		return outOfMarks;
	}

	public Double getTotalMarks() {
		return totalMarks;
	}

	public Double getAvgMarks() {
		return avgMarks;
	}

	public String getPerformance() {
		return performance;
	}

	public void setKey(CandidateEvaluationCompositKey key) {
		this.key = key;
	}

	public void setSubmittedDate(LocalDateTime submittedDate) {
		this.submittedDate = submittedDate;
	}

	public void setAttireBodyLanguage(Double attireBodyLanguage) {
		this.attireBodyLanguage = attireBodyLanguage;
	}

	public void setWorkKnowledge(Double workKnowledge) {
		this.workKnowledge = workKnowledge;
	}

	public void setTeamPlayer(Double teamPlayer) {
		this.teamPlayer = teamPlayer;
	}

	public void setProblemSolvingSkill(Double problemSolvingSkill) {
		this.problemSolvingSkill = problemSolvingSkill;
	}

	public void setCommunicationSkill(Double communicationSkill) {
		this.communicationSkill = communicationSkill;
	}

	public void setOutOfMarks(Double outOfMarks) {
		this.outOfMarks = outOfMarks;
	}

	public void setTotalMarks(Double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public void setAvgMarks(Double avgMarks) {
		this.avgMarks = avgMarks;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

}
