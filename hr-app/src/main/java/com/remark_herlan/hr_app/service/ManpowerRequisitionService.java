package com.remark_herlan.hr_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.ManpowerRequisitionDao;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.exceptions.InvalidRequestException;
import com.remark_herlan.hr_app.model.ManpowerRequisition;
import com.remark_herlan.hr_app.model.ManpowerRequisitionApprovalUniqueKey;
import com.remark_herlan.hr_app.model.ResponseInfo;

/**
 * author: Naimul Hassan
 * 
 * date: 2/8/2025
 */

@Service
public class ManpowerRequisitionService {

	@Autowired
	ManpowerRequisitionDao dao;

	@Autowired
	GetSequenceService sequenceService;

	public ResponseInfo<List<ManpowerRequisition>> getAllInfos() throws InternalServerException, DataNotFoundException {
		ResponseInfo<List<ManpowerRequisition>> responseInfo = new ResponseInfo<>();

		try {
			List<ManpowerRequisition> response = dao.findAll();

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

	public ResponseInfo<Optional<ManpowerRequisition>> getInfo(Long id)
			throws InternalServerException, DataNotFoundException {
		ResponseInfo<Optional<ManpowerRequisition>> responseInfo = new ResponseInfo<>();

		try {
			Optional<ManpowerRequisition> response = dao.findById(id);

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

	public ResponseInfo<List<ManpowerRequisition>> getInfoByTitle(String department)
			throws InternalServerException, DataNotFoundException {
		ResponseInfo<List<ManpowerRequisition>> responseInfo = new ResponseInfo<>();

		try {
			List<ManpowerRequisition> response = dao.findByDepartment(department);

			if (response.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	public ResponseInfo<Integer> updateRequisitionStatus(String status, Long id, String completedBy, String remarks)
			throws InternalServerException, DataNotFoundException, InvalidRequestException {
		ResponseInfo<Integer> responseInfo = new ResponseInfo<>();

		try {
			ManpowerRequisition requisitionResponse = dao.findById(id)
					.orElseThrow(() -> new DataNotFoundException("No data found!"));

			if (!"PENDING".equals(requisitionResponse.getStatus())) {
				throw new InvalidRequestException("This requisition is already completed!");
			}

			LocalDateTime currentDate = LocalDateTime.now();

			int response = dao.updateStatusById(status, currentDate, completedBy, remarks, id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Status updated!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			throw e;
		} catch (InvalidRequestException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<ManpowerRequisition> saveInfo(ManpowerRequisition manpowerRequisition)
			throws InternalServerException {
		ResponseInfo<ManpowerRequisition> responseInfo = new ResponseInfo<>();

		try {
			if (manpowerRequisition.getId() == null) {
				Long sequence = sequenceService.getSequenceId("id", "manpower_requisition");
				manpowerRequisition.setId(sequence);
			}

			ManpowerRequisition response = dao.save(manpowerRequisition);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

}
