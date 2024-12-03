package com.remark_herlan.hr_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.Candidates;
import java.util.List;
import java.time.LocalDateTime;


/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Repository
public interface CandidatesDao extends JpaRepository<Candidates, Long> {

	List<Candidates> findByFullName(String fullName);
	
	List<Candidates> findByInterviewDate(LocalDateTime interviewDate);

}
