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
import com.remark_herlan.hr_app.model.Candidates;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.service.CandidatesService;

/**
 * author: Naimul Hassan
 * 
 * date: 12/01/2024
 */

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {

	@Autowired
	CandidatesService service;

	@GetMapping("all")
	public ResponseInfo<List<Candidates>> getAllMethod() throws InternalServerException, DataNotFoundException {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<Candidates>> getMethod(@PathVariable Long id)
			throws InternalServerException, DataNotFoundException {
		return service.getInfo(id);
	}

	@PostMapping("/add")
	public ResponseInfo<Candidates> postMethod(@RequestBody Candidates candidates)
			throws InternalServerException, DataNotFoundException {
		return service.saveInfo(candidates);
	}

}
