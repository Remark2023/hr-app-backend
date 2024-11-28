package com.remark_herlan.hr_app.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.ResponseInfo;

/**
 * author: Naimul Hassan 
 * 
 * date: 11/27/2024
 */

/**
 * class to handle exceptions
 */

@RestControllerAdvice
public class ApplicationExceptionHandler {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
//        return errorMap;
//    }

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseInfo<Map<String, String>> handleInvalidArgument(HttpMessageNotReadableException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", "Invalid request body");
		errorMap.put("message", ex.getMostSpecificCause().getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();

		responseInfo.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseInfo.setMessage(HttpStatus.NO_CONTENT.name());
		responseInfo.setData(errorMap);

		return responseInfo;
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseInfo<Map<String, String>> handleDataNotFoundException(DataNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();

		responseInfo.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseInfo.setMessage(HttpStatus.NO_CONTENT.name());
		responseInfo.setData(errorMap);

		return responseInfo;
	}

	@ExceptionHandler(InternalServerException.class)
	public ResponseInfo<Map<String, String>> handleInternalServerException(InternalServerException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage(HttpStatus.BAD_REQUEST.name());
		responseInfo.setData(errorMap);

		return responseInfo;
	}

}