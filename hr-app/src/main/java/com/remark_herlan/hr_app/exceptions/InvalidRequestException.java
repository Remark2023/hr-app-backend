package com.remark_herlan.hr_app.exceptions;

/**
 * author: Naimul Hassan 
 * 
 * date: 2/19/2025
 */

/**
 * class to catch custom exceptions
 */

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidRequestException(String message) {
		super(message);
	}

}
