package com.cts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cts.bo.ExceptionBO;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionBO> exceptionHandler(Exception ex) {
		ExceptionBO error = new ExceptionBO("Please contact your administrator", ex);
		return new ResponseEntity<ExceptionBO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
