package com.remark_herlan.hr_app.secutiry.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Users;
import com.remark_herlan.hr_app.secutiry.auth.jwt.JwtTokenUtil;
import com.remark_herlan.hr_app.service.UsersService;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsersService usersService;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

	@PostMapping("/login")
	public ResponseInfo<String> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String token = jwtTokenUtil.generateToken(userDetails);

		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		responseInfo.setStatusCode(HttpStatus.OK.value());
		responseInfo.setMessage("Login Successful!");
		responseInfo.setData(token);

		return responseInfo;
	}

	@PostMapping("/signup")
	public ResponseInfo<String> registerUser(@RequestBody Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return usersService.saveInfo(user);
	}

}
