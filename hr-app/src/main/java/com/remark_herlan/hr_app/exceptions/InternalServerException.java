package com.remark_herlan.hr_app.exceptions;

/**
 * author: Naimul Hassan 
 * 
 * date: 11/27/2024
 */

/**
 * class to catch custom exceptions
 */

public class InternalServerException extends Exception {

	private static final long serialVersionUID = 1L;

	public InternalServerException(String message) {
		super(message);
	}

}
