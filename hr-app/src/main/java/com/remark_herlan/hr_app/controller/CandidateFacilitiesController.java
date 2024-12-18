package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.exceptions.AuthorizationException;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.CandidateFacilities;
import com.remark_herlan.hr_app.model.Candidates;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.service.CandidateFacilitiesService;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@RestController
@RequestMapping("api/facilities")
public class CandidateFacilitiesController {

	@Autowired
	CandidateFacilitiesService service;

	@GetMapping("all")
	public ResponseInfo<List<CandidateFacilities>> getAllMethod()
			throws InternalServerException, DataNotFoundException {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<CandidateFacilities>> getMethod(@PathVariable Long id)
			throws InternalServerException, DataNotFoundException {
		return service.getInfo(id);
	}

	@PostMapping("byCandidate/{type}")
	public ResponseInfo<CandidateFacilities> getByCandidateMethod(@RequestBody Candidates candidate,
			@PathVariable String type) throws InternalServerException, DataNotFoundException {
		return service.getInfoByCandidate(candidate, type);
	}

	@PostMapping("/add")
	public ResponseInfo<CandidateFacilities> postMethod(@RequestBody CandidateFacilities facility,
			@RequestAttribute(name = "role", required = false) String role)
			throws InternalServerException, AuthorizationException {
		return service.saveInfo(facility, role);
	}

}
