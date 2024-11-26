package com.remark_herlan.hr_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Roles;
import com.remark_herlan.hr_app.service.RolesService;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@RestController
@RequestMapping("roles")
public class RolesController {

	@Autowired
	RolesService service;

	@GetMapping("all")
	public ResponseInfo<List<Roles>> getAllMethod() {
		return service.getAllInfos();
	}

}
