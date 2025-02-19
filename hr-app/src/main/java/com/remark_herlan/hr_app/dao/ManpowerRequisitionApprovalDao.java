package com.remark_herlan.hr_app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.ManpowerRequisition;
import com.remark_herlan.hr_app.model.ManpowerRequisitionApproval;
import com.remark_herlan.hr_app.model.ManpowerRequisitionApprovalUniqueKey;
import com.remark_herlan.hr_app.model.Users;

import jakarta.transaction.Transactional;

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

	List<ManpowerRequisitionApproval> findByApprovalOf(ManpowerRequisition approvalOf);

	@Modifying
	@Transactional
	@Query("UPDATE ManpowerRequisitionApproval mra SET mra.status = :status, mra.approvalDate=:approvalDate, mra.remarks=:remarks WHERE mra.manpowerRequisitionApprovalUniqueKey = :key")
	int updateStatusByKey(@Param("status") String status, @Param("approvalDate") LocalDateTime approvalDate,
			@Param("remarks") String remarks, @Param("key") ManpowerRequisitionApprovalUniqueKey key);

}
