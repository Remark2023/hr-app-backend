package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.exceptions.AuthorizationException;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.exceptions.InvalidRequestException;
import com.remark_herlan.hr_app.model.ManpowerRequisition;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Roles;
import com.remark_herlan.hr_app.service.ManpowerRequisitionService;

import io.micrometer.common.util.StringUtils;

/**
 * author: Naimul Hassan
 * 
 * date: 2/8/2025
 */

@RestController
@RequestMapping("/api/jwt/manpowerRequisition")
public class ManpowerRequisitionController {

	@Autowired
	ManpowerRequisitionService service;

	@GetMapping("all")
	public ResponseInfo<List<ManpowerRequisition>> getAllMethod()
			throws InternalServerException, DataNotFoundException {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<ManpowerRequisition>> getMethod(@PathVariable Long id)
			throws InternalServerException, DataNotFoundException {
		return service.getInfo(id);
	}

	@GetMapping("/byDepartment/{department}")
	public ResponseInfo<List<ManpowerRequisition>> getByTitleMethod(@PathVariable String department)
			throws InternalServerException, DataNotFoundException {
		return service.getInfoByTitle(department);
	}

	@PutMapping("/status/update")
	public ResponseInfo<Integer> updateStatusMethod(@RequestBody ManpowerRequisition manpowerRequisition,
			@RequestAttribute(name = "roles", required = false) List<Roles> roles,
			@RequestAttribute("username") String username)
			throws InternalServerException, DataNotFoundException, AuthorizationException, InvalidRequestException {

		// Validate request body
		if (manpowerRequisition == null || manpowerRequisition.getId() == null
				|| StringUtils.isBlank(manpowerRequisition.getStatus())) {
			throw new InvalidRequestException("Invalid request: Requisition ID and status must be provided.");
		}

		if (CollectionUtils.isEmpty(roles) || roles.stream()
				.noneMatch(role -> "MANPOWER REQUISITION APPROVER".equalsIgnoreCase(role.getTitle()))) {
			throw new AuthorizationException("Access denied: You do not have approval privileges.");
		}

		return service.updateRequisitionStatus(manpowerRequisition.getStatus(), manpowerRequisition.getId(), username,
				manpowerRequisition.getRemarks());
	}

	@PostMapping("/add")
	public ResponseInfo<ManpowerRequisition> postMethod(@RequestBody ManpowerRequisition manpowerRequisition)
			throws InternalServerException {
		return service.saveInfo(manpowerRequisition);
	}

}
