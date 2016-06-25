package com.abpadan.webapp.exception;

public enum Error {
	
	DUPLICATE_USERNAME("A user with the specified username already exists");
	
	private String message; 
	
	Error(String message) {
		this.message = message; 
	}
	
	public String getMessage() {
		return message;
	}

}
