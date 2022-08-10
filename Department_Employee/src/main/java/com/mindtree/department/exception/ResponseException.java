package com.mindtree.department.exception;

import java.util.Date;

public class ResponseException {

	private Date date;
	private int code;
	private String message;
	private String details;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ResponseException(Date date,int code, String message, String details) {
		super();
		this.date = date;
		this.code = code;
		this.message = message;
		this.details = details;
	}
	public ResponseException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
