package com.remark_herlan.hr_app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.CandidateFacilitiesDao;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.CandidateFacilities;
import com.remark_herlan.hr_app.model.Candidates;
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

	@Autowired
	GetSequenceService sequenceService;

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

	public ResponseInfo<Optional<CandidateFacilities>> getInfo(Long id)
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

	public ResponseInfo<CandidateFacilities> getInfoByCandidate(Candidates candidate, String type)
			throws InternalServerException, DataNotFoundException {
		ResponseInfo<CandidateFacilities> responseInfo = new ResponseInfo<>();

		try {
			List<CandidateFacilities> response = dao.findByCandidate(candidate);

			if (response.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			List<CandidateFacilities> filteredFacilities = response.stream()
					.filter(facility -> type.equals(facility.getFacilityType())).collect(Collectors.toList());

			if (filteredFacilities.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			CandidateFacilities facilityInfo = filteredFacilities.get(0);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(facilityInfo);

			return responseInfo;
		} catch (DataNotFoundException e) {
			// Explicitly handle known exception
			throw e; // Re-throw to let a higher-level handler manage it
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	public ResponseInfo<CandidateFacilities> saveInfo(CandidateFacilities candidateFacilities)
			throws InternalServerException {

		ResponseInfo<CandidateFacilities> responseInfo = new ResponseInfo<>();

		try {
			Long sequence = sequenceService.getSequenceId("id", "candidate_facilities");
			if (candidateFacilities.getId() == null) {
				candidateFacilities.setId(sequence);
			}

			CandidateFacilities response = dao.save(candidateFacilities);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(response);

			return responseInfo;
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
