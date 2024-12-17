package com.remark_herlan.hr_app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/byDate")
	public ResponseInfo<List<Candidates>> getByDateMethod(
			@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
			throws InternalServerException, DataNotFoundException {
		return service.getInfoByDate(date);
	}

	@GetMapping("/byNid")
	public ResponseInfo<List<Candidates>> getByNidMethod(@RequestParam(value = "nid") String nid)
			throws InternalServerException, DataNotFoundException {
		return service.getInfoByNid(nid);
	}

	@PostMapping("/add")
	public ResponseInfo<Candidates> postMethod(@RequestBody Candidates candidates)
			throws InternalServerException, DataNotFoundException {
		return service.saveInfo(candidates);
	}

	@PutMapping("/update/byNumber")
	public ResponseInfo<Integer> updateMethod(@RequestBody Candidates candidates)
			throws InternalServerException, DataNotFoundException {
		return service.updateInfoByCandidateNumber(candidates);
	}

}
