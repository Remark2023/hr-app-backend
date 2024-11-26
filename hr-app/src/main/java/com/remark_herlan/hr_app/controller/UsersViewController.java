package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.UsersView;
import com.remark_herlan.hr_app.service.UsersViewService;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@RestController
@RequestMapping("users-view")
public class UsersViewController {

	@Autowired
	UsersViewService service;

	@GetMapping("all")
	public ResponseInfo<List<UsersView>> getAllMethod() {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<UsersView>> getMethod(@PathVariable Long id) {
		return service.getInfo(id);
	}

	@GetMapping("/byUsername/{username}")
	public ResponseInfo<UsersView> getByNameMethod(@PathVariable String username) {
		return service.getInfoByUsername(username);
	}

}
