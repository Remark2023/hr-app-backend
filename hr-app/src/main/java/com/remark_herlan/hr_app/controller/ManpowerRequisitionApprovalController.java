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
import com.remark_herlan.hr_app.model.ManpowerRequisitionApproval;
import com.remark_herlan.hr_app.model.ManpowerRequisitionApprovalUniqueKey;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Roles;
import com.remark_herlan.hr_app.model.Users;
import com.remark_herlan.hr_app.service.ManpowerRequisitionApprovalService;

import io.micrometer.common.util.StringUtils;

/**
 * author: Naimul Hassan
 * 
 * date: 2/8/2025
 */

@RestController
@RequestMapping("/api/jwt/manpowerRequisitionApproval")
public class ManpowerRequisitionApprovalController {

	@Autowired
	ManpowerRequisitionApprovalService service;

	@GetMapping("all")
	public ResponseInfo<List<ManpowerRequisitionApproval>> getAllMethod()
			throws InternalServerException, DataNotFoundException {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<ManpowerRequisitionApproval>> getMethod(
			@PathVariable ManpowerRequisitionApprovalUniqueKey id)
			throws InternalServerException, DataNotFoundException {
		return service.getInfo(id);
	}

	@GetMapping("/byStatus/{status}")
	public ResponseInfo<List<ManpowerRequisitionApproval>> getByStatusMethod(@PathVariable String status)
			throws InternalServerException, DataNotFoundException {
		return service.getInfoByStatus(status);
	}

	@PostMapping("/get/byApprover/{status}")
	public ResponseInfo<List<ManpowerRequisitionApproval>> getByApproverMethod(@RequestBody Users approver,
			@PathVariable String status) throws InternalServerException, DataNotFoundException {
		return service.getInfoByApprover(approver, status);
	}

	@PostMapping("/get/byRequisition")
	public ResponseInfo<List<ManpowerRequisitionApproval>> getByRequisitionMethod(
			@RequestBody ManpowerRequisition manpowerRequisition)
			throws InternalServerException, DataNotFoundException {
		return service.getInfoByRequisition(manpowerRequisition);
	}

	@PutMapping("/status/update")
	public ResponseInfo<Integer> updateStatusMethod(
			@RequestBody ManpowerRequisitionApproval manpowerRequisitionApproval,
			@RequestAttribute(name = "roles", required = false) List<Roles> roles,
			@RequestAttribute("username") String username)
			throws InternalServerException, DataNotFoundException, AuthorizationException, InvalidRequestException {

		// Validate request body
		if (manpowerRequisitionApproval == null
				|| manpowerRequisitionApproval.getManpowerRequisitionApprovalUniqueKey() == null
				|| StringUtils.isBlank(manpowerRequisitionApproval.getStatus())) {
			throw new InvalidRequestException("Invalid request: Requisition ID and status must be provided.");
		}

		if (CollectionUtils.isEmpty(roles) || roles.stream()
				.noneMatch(role -> "MANPOWER REQUISITION APPROVER".equalsIgnoreCase(role.getTitle()))) {
			throw new AuthorizationException(
					"Access denied: Only users with 'MANPOWER REQUISITION APPROVER' role can approve.");
		}

		return service.updateApprovalStatus(manpowerRequisitionApproval.getStatus(),
				manpowerRequisitionApproval.getManpowerRequisitionApprovalUniqueKey(), username,
				manpowerRequisitionApproval.getRemarks());
	}

	@PostMapping("/add")
	public ResponseInfo<String> postMethod(@RequestBody ManpowerRequisitionApproval manpowerRequisitionApproval,
			@RequestAttribute("username") String username) throws InternalServerException {
		return service.saveInfo(manpowerRequisitionApproval, username);
	}

}
