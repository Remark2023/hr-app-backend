package com.remark_herlan.hr_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.ManpowerRequisitionApproval;
import com.remark_herlan.hr_app.model.ManpowerRequisitionApprovalUniqueKey;
import com.remark_herlan.hr_app.model.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 2/8/2025
 */

@Repository
public interface ManpowerRequisitionApprovalDao
		extends JpaRepository<ManpowerRequisitionApproval, ManpowerRequisitionApprovalUniqueKey> {

	List<ManpowerRequisitionApproval> findByStatus(String status);

	List<ManpowerRequisitionApproval> findByApprovedBy(Users approver);

}
