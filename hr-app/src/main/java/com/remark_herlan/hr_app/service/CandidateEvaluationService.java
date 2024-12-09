package com.remark_herlan.hr_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.CandidateEvaluationDao;
import com.remark_herlan.hr_app.exceptions.AuthorizationException;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.CandidateEvaluation;
import com.remark_herlan.hr_app.model.ResponseInfo;

/**
 * author: Naimul Hassan
 * 
 * date: 11/30/2024
 */

@Service
public class CandidateEvaluationService {

	@Autowired
	CandidateEvaluationDao dao;
	
	@Autowired
	GetSequenceService sequenceService;

	public ResponseInfo<List<CandidateEvaluation>> getAllInfos() throws InternalServerException, DataNotFoundException {
		ResponseInfo<List<CandidateEvaluation>> responseInfo = new ResponseInfo<>();

		try {
			List<CandidateEvaluation> response = dao.findAll();

			if (response.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			// Explicitly handle known exception
			throw e; // Re-throw to let a higher-level handler manage it
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	public ResponseInfo<Optional<CandidateEvaluation>> getInfo(Long id)
			throws InternalServerException, DataNotFoundException {
		ResponseInfo<Optional<CandidateEvaluation>> responseInfo = new ResponseInfo<>();

		try {
			Optional<CandidateEvaluation> response = dao.findById(id);

			if (response.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			// Explicitly handle known exception
			throw e; // Re-throw to let a higher-level handler manage it
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	public ResponseInfo<String> saveInfo(CandidateEvaluation candidateEvaluation, String username, String role)
			throws InternalServerException, AuthorizationException {

		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			if (!"INTERVIEWER".equals(role)) {
				throw new AuthorizationException(
						"Access denied: Only interviewers are allowed to perform this action.");
			}

			Long sequence = sequenceService.getSequenceId("candidate_number", "candidates");
			LocalDateTime creationDate = LocalDateTime.now();

			candidateEvaluation.setId(sequence);
			candidateEvaluation.setSubmittedDate(creationDate);
			candidateEvaluation.setSubmittedBy(username);

			dao.save(candidateEvaluation);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData("Candidate evaluation saved successfully.");

			return responseInfo;
		} catch (AuthorizationException authEx) {
			throw authEx;
		} catch (Exception ex) {
			throw new InternalServerException("An unexpected error occurred: " + ex.getMessage());
		}
	}

	public ResponseInfo<String> deleteInfo(Long id) throws InternalServerException {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.deleteById(id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully deleted id: " + id);
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	public ResponseInfo<String> deleteAllInfos() throws InternalServerException {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.deleteAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully truncated");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

}
