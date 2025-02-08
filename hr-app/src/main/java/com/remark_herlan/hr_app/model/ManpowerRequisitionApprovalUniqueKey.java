package com.remark_herlan.hr_app.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ManpowerRequisitionApprovalUniqueKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long approvalOfId; // Store only the ID
	private Long approvedById; // Store only the ID

	public ManpowerRequisitionApprovalUniqueKey() {
	}

	public ManpowerRequisitionApprovalUniqueKey(Long approvalOfId, Long approvedById) {
		this.approvalOfId = approvalOfId;
		this.approvedById = approvedById;
	}

	public Long getApprovalOfId() {
		return approvalOfId;
	}

	public void setApprovalOfId(Long approvalOfId) {
		this.approvalOfId = approvalOfId;
	}

	public Long getApprovedById() {
		return approvedById;
	}

	public void setApprovedById(Long approvedById) {
		this.approvedById = approvedById;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ManpowerRequisitionApprovalUniqueKey that = (ManpowerRequisitionApprovalUniqueKey) o;
		return Objects.equals(approvalOfId, that.approvalOfId) && Objects.equals(approvedById, that.approvedById);
	}

	@Override
	public int hashCode() {
		return Objects.hash(approvalOfId, approvedById);
	}
}
