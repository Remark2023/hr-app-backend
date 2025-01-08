package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.exceptions.AuthorizationException;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Roles;
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

	@GetMapping("/byStatus/{status}")
	public ResponseInfo<List<Users>> getByStatusMethod(@PathVariable String status)
			throws DataNotFoundException, InternalServerException {
		return service.getInfoByStatus(status);
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
	public ResponseInfo<Users> postMethod(@Validated @RequestBody Users user) throws InternalServerException {
		return service.saveInfo(user);
	}

	@PutMapping("/status/update")
	public ResponseInfo<Integer> updateStatusMethod(@RequestBody Users user,
			@RequestAttribute(name = "roles", required = false) List<Roles> roles)
			throws InternalServerException, DataNotFoundException, AuthorizationException {

		if (roles == null || roles.stream().noneMatch(role -> "ADMIN".equals(role.getTitle()))) {
			throw new AuthorizationException("Access denied: Only SUPER ADMIN is allowed to perform this action.");
		}

		return service.updateSignupStatus(user);
	}

	@GetMapping("roles")
	public ResponseInfo<List<String>> getRolesMethod(
			@RequestAttribute(name = "userRoles", required = false) List<String> userRoles)
			throws DataNotFoundException, InternalServerException, AuthorizationException {
		if (userRoles == null) {
			throw new AuthorizationException("Access denied: No user found.");
		}

		return service.getRoles(userRoles);
	}

}
