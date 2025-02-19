package com.remark_herlan.hr_app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.ManpowerRequisition;

import jakarta.transaction.Transactional;

/**
 * author: Naimul Hassan
 * 
 * date: 2/8/2025
 */

@Repository
public interface ManpowerRequisitionDao extends JpaRepository<ManpowerRequisition, Long> {

	List<ManpowerRequisition> findByDepartment(String department);

	List<ManpowerRequisition> findByStatus(String status);

	@Modifying
	@Transactional
	@Query("UPDATE ManpowerRequisition mr SET mr.status = :status, mr.completionDate=:completionDate, mr.completedBy=:completedBy, mr.remarks=:remarks WHERE mr.id = :id")
	int updateStatusById(@Param("status") String status,
			@Param("completionDate") LocalDateTime completionDate,
			@Param("completedBy") String completedBy, @Param("remarks") String remarks, @Param("id") Long id);

}
