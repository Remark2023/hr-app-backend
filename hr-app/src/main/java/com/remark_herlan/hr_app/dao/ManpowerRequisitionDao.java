package com.remark_herlan.hr_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.ManpowerRequisition;

/**
 * author: Naimul Hassan
 * 
 * date: 2/8/2025
 */

@Repository
public interface ManpowerRequisitionDao extends JpaRepository<ManpowerRequisition, Long> {

	List<ManpowerRequisition> findByDepartment(String department);

}
