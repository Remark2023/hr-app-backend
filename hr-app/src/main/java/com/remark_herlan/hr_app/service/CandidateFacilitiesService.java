package com.remark_herlan.hr_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.CandidateFacilitiesDao;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.CandidateFacilities;
import com.remark_herlan.hr_app.model.CandidateFacilitiesCompositeKey;
import com.remark_herlan.hr_app.model.ResponseInfo;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@Service
public class CandidateFacilitiesService {

	@Autowired
	CandidateFacilitiesDao dao;

	public ResponseInfo<List<CandidateFacilities>> getAllInfos() throws InternalServerException, DataNotFoundException {
		ResponseInfo<List<CandidateFacilities>> responseInfo = new ResponseInfo<>();

		try {
			List<CandidateFacilities> response = dao.findAll();

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

	public ResponseInfo<Optional<CandidateFacilities>> getInfo(CandidateFacilitiesCompositeKey id)
			throws InternalServerException, DataNotFoundException {
		ResponseInfo<Optional<CandidateFacilities>> responseInfo = new ResponseInfo<>();

		try {
			Optional<CandidateFacilities> response = dao.findById(id);

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

	public ResponseInfo<String> saveInfo(CandidateFacilities candidateFacilities) throws InternalServerException {

		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.save(candidateFacilities);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData("Candidate evaluation saved successfully.");

			return responseInfo;
		} catch (Exception ex) {
			throw new InternalServerException("An unexpected error occurred: " + ex.getMessage());
		}
	}

	public ResponseInfo<String> deleteInfo(CandidateFacilitiesCompositeKey id) throws InternalServerException {
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
