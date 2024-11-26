package com.remark_herlan.hr_app.secutiry.auth;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

public class AuthenticationRequest {
	private String username;
	private String password;

	// Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}