package com.remark_herlan.hr_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.CandidatesDao;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.Candidates;
import com.remark_herlan.hr_app.model.ResponseInfo;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Service
public class CandidatesService {

	@Autowired
	CandidatesDao dao;

	@Autowired
	GetSequenceService sequenceService;

	public ResponseInfo<List<Candidates>> getAllInfos() throws InternalServerException, DataNotFoundException {
		ResponseInfo<List<Candidates>> responseInfo = new ResponseInfo<>();

		try {
			List<Candidates> response = dao.findAll();

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

	public ResponseInfo<Optional<Candidates>> getInfo(Long id) throws InternalServerException, DataNotFoundException {
		ResponseInfo<Optional<Candidates>> responseInfo = new ResponseInfo<>();

		try {
			Optional<Candidates> response = dao.findById(id);

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

	public ResponseInfo<Candidates> saveInfo(Candidates candidate) throws InternalServerException {
		ResponseInfo<Candidates> responseInfo = new ResponseInfo<>();

		try {
			Long sequence = sequenceService.getSequenceId("candidate_number", "candidates");
			candidate.setCandidateNumber(sequence);

			Candidates response = dao.save(candidate);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
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
