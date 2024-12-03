package com.remark_herlan.hr_app.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Entity
public class Candidates {

	@Id
	private Long candidateNumber;
	private String FullName;
	private String age;
	private String email;
	private String contactNumber;
	private String nidNumber;
	private String presentAddress;
	private String permanentAddress;
	private String lastEducationExam;
	private String lastEducationSubject;
	private String lastEducationInstitute;
	private String lastEducationYear;
	private String lastEducationResult;
	private String fatherName;
	private String motherName;
	private Integer numberOfSiblings;
	private String ReferenceName;
	private String referenceRelation;
	private String referenceDesignation;
	private Boolean haveReference;
	private String noticePeriods;
	private String hrNotes;
	private String managementComment;
	private String doj;
	private String probationPeriod;
	private String investigation;
	private LocalDateTime interviewDate;
	private Boolean interestedToJoin;
	private Boolean bond2Years;
	private Boolean bond5Years;
	private Boolean havePassport;
	private Boolean haveDrivingLicense;
	private Boolean workAnywhereInBd;
	private Boolean workAtFactory;
	private Boolean operateComp;
	private Boolean agreedTerms;
	private String sbu;
	private String department;
	private String reportsTo;
	private String designation;
	private Boolean haveExperiences;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CandidateExperiences> experiences;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CandidateFacilities> facilitiesInfo;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CandidateEvaluation> evaluationInfo;

	public Long getCandidateNumber() {
		return candidateNumber;
	}

	public String getFullName() {
		return FullName;
	}

	public String getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getNidNumber() {
		return nidNumber;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public String getLastEducationExam() {
		return lastEducationExam;
	}

	public String getLastEducationSubject() {
		return lastEducationSubject;
	}

	public String getLastEducationInstitute() {
		return lastEducationInstitute;
	}

	public String getLastEducationYear() {
		return lastEducationYear;
	}

	public String getLastEducationResult() {
		return lastEducationResult;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public Integer getNumberOfSiblings() {
		return numberOfSiblings;
	}

	public String getReferenceName() {
		return ReferenceName;
	}

	public String getReferenceRelation() {
		return referenceRelation;
	}

	public String getReferenceDesignation() {
		return referenceDesignation;
	}

	public Boolean getHaveReference() {
		return haveReference;
	}

	public String getNoticePeriods() {
		return noticePeriods;
	}

	public String getHrNotes() {
		return hrNotes;
	}

	public String getManagementComment() {
		return managementComment;
	}

	public String getDoj() {
		return doj;
	}

	public String getProbationPeriod() {
		return probationPeriod;
	}

	public String getInvestigation() {
		return investigation;
	}

	public LocalDateTime getInterviewDate() {
		return interviewDate;
	}

	public Boolean getInterestedToJoin() {
		return interestedToJoin;
	}

	public Boolean getBond2Years() {
		return bond2Years;
	}

	public Boolean getBond5Years() {
		return bond5Years;
	}

	public Boolean getHavePassport() {
		return havePassport;
	}

	public Boolean getHaveDrivingLicense() {
		return haveDrivingLicense;
	}

	public Boolean getWorkAnywhereInBd() {
		return workAnywhereInBd;
	}

	public Boolean getWorkAtFactory() {
		return workAtFactory;
	}

	public Boolean getOperateComp() {
		return operateComp;
	}

	public Boolean getAgreedTerms() {
		return agreedTerms;
	}

	public String getSbu() {
		return sbu;
	}

	public String getDepartment() {
		return department;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public String getDesignation() {
		return designation;
	}

	public Boolean getHaveExperiences() {
		return haveExperiences;
	}

	public List<CandidateExperiences> getExperiences() {
		return experiences;
	}

	public List<CandidateFacilities> getFacilitiesInfo() {
		return facilitiesInfo;
	}

	public List<CandidateEvaluation> getEvaluationInfo() {
		return evaluationInfo;
	}

	public void setCandidateNumber(Long candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setNidNumber(String nidNumber) {
		this.nidNumber = nidNumber;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public void setLastEducationExam(String lastEducationExam) {
		this.lastEducationExam = lastEducationExam;
	}

	public void setLastEducationSubject(String lastEducationSubject) {
		this.lastEducationSubject = lastEducationSubject;
	}

	public void setLastEducationInstitute(String lastEducationInstitute) {
		this.lastEducationInstitute = lastEducationInstitute;
	}

	public void setLastEducationYear(String lastEducationYear) {
		this.lastEducationYear = lastEducationYear;
	}

	public void setLastEducationResult(String lastEducationResult) {
		this.lastEducationResult = lastEducationResult;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public void setNumberOfSiblings(Integer numberOfSiblings) {
		this.numberOfSiblings = numberOfSiblings;
	}

	public void setReferenceName(String referenceName) {
		ReferenceName = referenceName;
	}

	public void setReferenceRelation(String referenceRelation) {
		this.referenceRelation = referenceRelation;
	}

	public void setReferenceDesignation(String referenceDesignation) {
		this.referenceDesignation = referenceDesignation;
	}

	public void setHaveReference(Boolean haveReference) {
		this.haveReference = haveReference;
	}

	public void setNoticePeriods(String noticePeriods) {
		this.noticePeriods = noticePeriods;
	}

	public void setHrNotes(String hrNotes) {
		this.hrNotes = hrNotes;
	}

	public void setManagementComment(String managementComment) {
		this.managementComment = managementComment;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public void setProbationPeriod(String probationPeriod) {
		this.probationPeriod = probationPeriod;
	}

	public void setInvestigation(String investigation) {
		this.investigation = investigation;
	}

	public void setInterviewDate(LocalDateTime interviewDate) {
		this.interviewDate = interviewDate;
	}

	public void setInterestedToJoin(Boolean interestedToJoin) {
		this.interestedToJoin = interestedToJoin;
	}

	public void setBond2Years(Boolean bond2Years) {
		this.bond2Years = bond2Years;
	}

	public void setBond5Years(Boolean bond5Years) {
		this.bond5Years = bond5Years;
	}

	public void setHavePassport(Boolean havePassport) {
		this.havePassport = havePassport;
	}

	public void setHaveDrivingLicense(Boolean haveDrivingLicense) {
		this.haveDrivingLicense = haveDrivingLicense;
	}

	public void setWorkAnywhereInBd(Boolean workAnywhereInBd) {
		this.workAnywhereInBd = workAnywhereInBd;
	}

	public void setWorkAtFactory(Boolean workAtFactory) {
		this.workAtFactory = workAtFactory;
	}

	public void setOperateComp(Boolean operateComp) {
		this.operateComp = operateComp;
	}

	public void setAgreedTerms(Boolean agreedTerms) {
		this.agreedTerms = agreedTerms;
	}

	public void setSbu(String sbu) {
		this.sbu = sbu;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setHaveExperiences(Boolean haveExperiences) {
		this.haveExperiences = haveExperiences;
	}

	public void setExperiences(List<CandidateExperiences> experiences) {
		this.experiences = experiences;
	}

	public void setFacilitiesInfo(List<CandidateFacilities> facilitiesInfo) {
		this.facilitiesInfo = facilitiesInfo;
	}

	public void setEvaluationInfo(List<CandidateEvaluation> evaluationInfo) {
		this.evaluationInfo = evaluationInfo;
	}

}
