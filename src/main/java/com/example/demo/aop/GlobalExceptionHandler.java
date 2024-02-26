package com.example.demo.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.NoEmpFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler (value = Exception.class)
	public ResponseEntity<String> handleInternalServerError(Exception e) {
		return new ResponseEntity<> ("Internal Server Error, please try after some time", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NoEmpFoundException.class)
	public ResponseEntity<String> handleNoEmpFoundException (NoEmpFoundException ex) {
		return new ResponseEntity("No Record found.", HttpStatus.OK);
	}
}
