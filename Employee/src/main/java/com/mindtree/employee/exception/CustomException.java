package com.mindtree.employee.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DetailsNotFoundException.class)
	public final ResponseEntity<Object> detaildNotFoundExceptionHandler(Exception e,WebRequest wr)
	{
		ResponseException re = new ResponseException(new Date(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<>(re, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> allExceptionHandler(Exception e,WebRequest wr)
	{
		ResponseException re = new ResponseException(new Date(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<>(re, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
