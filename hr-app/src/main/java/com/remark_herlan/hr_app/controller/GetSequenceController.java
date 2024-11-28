package com.remark_herlan.hr_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.service.GetSequenceService;

@RestController
@RequestMapping("sequence")
public class GetSequenceController {

	@Autowired
	GetSequenceService service;

	@GetMapping("/get")
	public ResponseInfo<Long> getNewSequenceId(@RequestParam("primaryKey") String primaryKey,
			@RequestParam("tableName") String tableName) throws InternalServerException, DataNotFoundException {
		return service.generateNewSequenceId(primaryKey, tableName);
	}

}
