package com.remark_herlan.hr_app.exceptions;

/**
 * author: Naimul Hassan 
 * 
 * date: 11/28/2024
 */

/**
 * class to catch custom exceptions
 */

public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}

}