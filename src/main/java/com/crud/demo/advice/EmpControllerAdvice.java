package com.crud.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.crud.demo.custom.exceptions.EmptyInputException;

@ControllerAdvice
public class EmpControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Input is empty. Please check", HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleNoElementInDB(EmptyResultDataAccessException emptyResultDataAccessException){
		return new ResponseEntity<String>("Element not in DB", HttpStatus.NOT_FOUND);
		
	}
	
	
	  @ExceptionHandler(NoSuchElementException.class) 
	  public ResponseEntity<String> handleNoElementInDB(NoSuchElementException noSuchElementException){ 
		  return new ResponseEntity<String>("No such element", HttpStatus.NOT_FOUND);
	  
	  }
	 
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>("Change http method type", HttpStatus.NOT_FOUND);
	}

}
