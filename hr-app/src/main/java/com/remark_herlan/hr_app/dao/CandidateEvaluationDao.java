package com.remark_herlan.hr_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.CandidateEvaluation;
import com.remark_herlan.hr_app.model.CandidateEvaluationCompositKey;

/**
 * author: Naimul Hassan
 * 
 * date: 11/30/2024
 */

@Repository
public interface CandidateEvaluationDao extends JpaRepository<CandidateEvaluation, CandidateEvaluationCompositKey> {

}
