package com.remark_herlan.hr_app.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	public ResponseEntity<ResponseInfo<Map<String, String>>> handleInvalidArgument(HttpMessageNotReadableException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", "Invalid request body");
		errorMap.put("message", ex.getMostSpecificCause().getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage(HttpStatus.BAD_REQUEST.name());
		responseInfo.setData(errorMap);

		return new ResponseEntity<>(responseInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ResponseInfo<Map<String, String>>> handleUsernameNotFoundException(
			UsernameNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", "Username not found");
		errorMap.put("message", ex.getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();
		responseInfo.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseInfo.setMessage("Username Not Found");
		responseInfo.setData(errorMap);

		return new ResponseEntity<>(responseInfo, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ResponseInfo<Map<String, String>>> handleAuthenticationException(AuthenticationException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", "Authentication failed");
		errorMap.put("message", ex.getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();
		responseInfo.setStatusCode(HttpStatus.UNAUTHORIZED.value()); // 401 Unauthorized
		responseInfo.setMessage("Authentication Failed");
		responseInfo.setData(errorMap);

		return new ResponseEntity<>(responseInfo, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseInfo<Map<String, String>>> handleDataNotFoundException(DataNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();

		responseInfo.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseInfo.setMessage(HttpStatus.NO_CONTENT.name());
		responseInfo.setData(errorMap);

		return new ResponseEntity<>(responseInfo, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<ResponseInfo<Map<String, String>>> handleInternalServerException(InternalServerException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());

		ResponseInfo<Map<String, String>> responseInfo = new ResponseInfo<>();

		responseInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseInfo.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.name());
		responseInfo.setData(errorMap);

		return new ResponseEntity<>(responseInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}