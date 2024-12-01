package com.remark_herlan.hr_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.Candidates;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Repository
public interface CandidatesDao extends JpaRepository<Candidates, Long> {

}
