package com.mindtree.employee.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DetailsNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DetailsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}