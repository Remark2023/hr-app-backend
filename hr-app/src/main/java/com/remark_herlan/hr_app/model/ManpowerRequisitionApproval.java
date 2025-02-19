package com.remark_herlan.hr_app.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ManpowerRequisitionApproval {

	@EmbeddedId
	private ManpowerRequisitionApprovalUniqueKey manpowerRequisitionApprovalUniqueKey;

	@ManyToOne
	@JoinColumn(name = "approvalOfId", insertable = false, updatable = false)
	private ManpowerRequisition approvalOf;

	@ManyToOne
	@JoinColumn(name = "approvedById", insertable = false, updatable = false)
	private Users approvedBy;

	private String status = "PENDING";
	private String remarks;
	private LocalDateTime approvalDate;

	@CreationTimestamp
	private LocalDateTime creationDate;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ManpowerRequisitionApprovalUniqueKey getManpowerRequisitionApprovalUniqueKey() {
		return manpowerRequisitionApprovalUniqueKey;
	}

	public void setManpowerRequisitionApprovalUniqueKey(
			ManpowerRequisitionApprovalUniqueKey manpowerRequisitionApprovalUniqueKey) {
		this.manpowerRequisitionApprovalUniqueKey = manpowerRequisitionApprovalUniqueKey;
	}

	public ManpowerRequisition getApprovalOf() {
		return approvalOf;
	}

	public void setApprovalOf(ManpowerRequisition approvalOf) {
		this.approvalOf = approvalOf;
	}

	public Users getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Users approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDateTime approvalDate) {
		this.approvalDate = approvalDate;
	}
}
