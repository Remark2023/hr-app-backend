package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.ManpowerRequisitionApproval;
import com.remark_herlan.hr_app.model.ManpowerRequisitionApprovalUniqueKey;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Users;
import com.remark_herlan.hr_app.service.ManpowerRequisitionApprovalService;

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

	@GetMapping("/byDepartment/{status}")
	public ResponseInfo<List<ManpowerRequisitionApproval>> getByTitleMethod(@PathVariable String status)
			throws InternalServerException, DataNotFoundException {
		return service.getInfoByStatus(status);
	}

	@PostMapping("/get/byApprover/{status}")
	public ResponseInfo<List<ManpowerRequisitionApproval>> getByApproverMethod(@RequestBody Users approver,
			@PathVariable String status) throws InternalServerException, DataNotFoundException {
		return service.getInfoByApprover(approver, status);
	}

	@PostMapping("/add")
	public ResponseInfo<String> postMethod(@RequestBody ManpowerRequisitionApproval manpowerRequisitionApproval)
			throws InternalServerException {
		return service.saveInfo(manpowerRequisitionApproval);
	}

}
