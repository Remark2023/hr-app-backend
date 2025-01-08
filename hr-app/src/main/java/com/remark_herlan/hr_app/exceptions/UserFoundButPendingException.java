package com.remark_herlan.hr_app.exceptions;

/**
 * author: Naimul Hassan 
 * 
 * date: 1/6/2025
 */

/**
 * class to catch custom exceptions
 */

public class UserFoundButPendingException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public UserFoundButPendingException(String message) {
		super(message);
	}

}
