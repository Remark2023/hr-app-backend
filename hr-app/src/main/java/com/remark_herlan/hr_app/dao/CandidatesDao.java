package com.remark_herlan.hr_app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.Candidates;

import jakarta.transaction.Transactional;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Repository
public interface CandidatesDao extends JpaRepository<Candidates, Long> {

	List<Candidates> findByFullName(String fullName);

	List<Candidates> findByInterviewDate(LocalDate interviewDate);

	List<Candidates> findByNidNumber(String nidNumber);

	@Modifying
	@Transactional
	@Query("UPDATE Candidates can " + "SET can.noticePeriods = :noticePeriods, " + "can.doj = :doj, "
			+ "can.probationPeriod = :probationPeriod, " + "can.investigation = :investigation, "
			+ "can.hrNotes = :hrNotes, " + "can.managementComment = :managementComment "
			+ "WHERE can.candidateNumber = :candidateNumber")
	int updateInfoById(@Param("noticePeriods") String noticePeriods, @Param("doj") String doj,
			@Param("probationPeriod") String probationPeriod, @Param("investigation") String investigation,
			@Param("hrNotes") String hrNotes, @Param("managementComment") String managementComment,
			@Param("candidateNumber") Long candidateNumber);

	@Modifying
	@Transactional
	@Query("UPDATE Candidates can SET can.status = :status WHERE can.candidateNumber = :candidateNumber")
	int updateStatusById(@Param("status") String status, @Param("candidateNumber") Long candidateNumber);

}
