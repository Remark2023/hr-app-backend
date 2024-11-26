package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Users;
import com.remark_herlan.hr_app.service.UsersService;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	UsersService service;

	@GetMapping("all")
	public ResponseInfo<List<Users>> getAllMethod() {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<Users>> getMethod(@PathVariable Integer id) {
		return service.getInfo(id);
	}

	@GetMapping("/byUsername/{username}")
	public ResponseInfo<Optional<Users>> getByNameMethod(@PathVariable String username) {
		return service.getInfoByUsername(username);
	}

	@PostMapping("/add")
	public ResponseInfo<String> postMethod(@Validated @RequestBody Users user) {
		return service.saveInfo(user);
	}

}
