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
import com.remark_herlan.hr_app.model.CandidateEvaluation;
import com.remark_herlan.hr_app.model.CandidateEvaluationCompositKey;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.service.CandidateEvaluationService;

/**
 * author: Naimul Hassan
 * 
 * date: 11/30/2024
 */

@RestController
@RequestMapping("api/evaluations")
public class CandidateEvaluationController {

	@Autowired
	CandidateEvaluationService service;

	@GetMapping("all")
	public ResponseInfo<List<CandidateEvaluation>> getAllMethod()
			throws InternalServerException, DataNotFoundException {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<CandidateEvaluation>> getMethod(@PathVariable CandidateEvaluationCompositKey id)
			throws InternalServerException, DataNotFoundException {
		return service.getInfo(id);
	}

	@PostMapping("/add")
	public ResponseInfo<String> postMethod(@RequestBody CandidateEvaluation evaluation) throws InternalServerException {
		return service.saveInfo(evaluation);
	}

}
