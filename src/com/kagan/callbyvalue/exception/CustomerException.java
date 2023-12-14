package com.kagan.callbyvalue.exception;

public class CustomerException extends Exception {

	private String explanation;

	public CustomerException(String explanation) {
		super();
		this.explanation = explanation;
	}
	
}
