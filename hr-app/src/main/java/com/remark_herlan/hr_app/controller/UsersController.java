package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Users;
import com.remark_herlan.hr_app.service.UsersService;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@RestController
@RequestMapping("api/users")
public class UsersController {

	@Autowired
	UsersService service;

	@GetMapping("all")
	public ResponseInfo<List<Users>> getAllMethod() throws DataNotFoundException, InternalServerException {
		return service.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<Users>> getMethod(@PathVariable Long id)
			throws DataNotFoundException, InternalServerException {
		return service.getInfo(id);
	}

	@GetMapping("get/byUsername")
	public ResponseInfo<Users> getByNameMethod(@RequestAttribute("username") String username)
			throws DataNotFoundException, InternalServerException {
		return service.getInfoByUsername(username);
	}

	@PostMapping("/add")
	public ResponseInfo<String> postMethod(@Validated @RequestBody Users user) throws InternalServerException {
		return service.saveInfo(user);
	}

}
