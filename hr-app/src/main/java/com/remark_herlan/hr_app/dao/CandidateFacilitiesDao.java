package com.remark_herlan.hr_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.CandidateFacilities;
import com.remark_herlan.hr_app.model.Candidates;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Repository
public interface CandidateFacilitiesDao extends JpaRepository<CandidateFacilities, Long> {

	List<CandidateFacilities> findByCandidate(Candidates candidate);
}
