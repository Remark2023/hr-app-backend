package com.remark_herlan.hr_app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
			List<Candidates> response = dao.findAll(Sort.by(Sort.Direction.ASC, "candidateNumber"));

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

	public ResponseInfo<List<Candidates>> getInfoByFullname(String name)
			throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<Candidates>> responseInfo = new ResponseInfo<>();

		try {
			List<Candidates> response = dao.findByFullName(name);

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

	public ResponseInfo<List<Candidates>> getInfoByDate(LocalDate date)
			throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<Candidates>> responseInfo = new ResponseInfo<>();

		try {
			List<Candidates> response = dao.findByInterviewDate(date);

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

	public ResponseInfo<List<Candidates>> getInfoByNid(String nidNumber)
			throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<Candidates>> responseInfo = new ResponseInfo<>();

		try {
			List<Candidates> response = dao.findByNidNumber(nidNumber);

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

	public ResponseInfo<List<Candidates>> getInfoByStatus(String status, int upperLimit, int lowerLimit)
			throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<Candidates>> responseInfo = new ResponseInfo<>();

		try {
			Pageable pageable = PageRequest.of(lowerLimit, upperLimit);

			List<Candidates> response = dao.findByStatusOrderByCandidateNumberAsc(status, pageable);

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
			if (candidate.getCandidateNumber() == null) {
				candidate.setCandidateNumber(sequence);
			}

			Candidates response = dao.save(candidate);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<Integer> updateInfoByCandidateNumber(Candidates candidate) throws InternalServerException {
		ResponseInfo<Integer> responseInfo = new ResponseInfo<>();

		try {
			int response = dao.updateInfoById(candidate.getNoticePeriods(), candidate.getDoj(),
					candidate.getProbationPeriod(), candidate.getInvestigation(), candidate.getHrNotes(),
					candidate.getManagementComment(), candidate.getCandidateNumber());

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully updated!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<Integer> updateStatusByCandidateNumber(Candidates candidate) throws InternalServerException {
		ResponseInfo<Integer> responseInfo = new ResponseInfo<>();

		try {
			int response = dao.updateStatusById(candidate.getStatus(), candidate.getCandidateNumber());

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Status updated!");
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
