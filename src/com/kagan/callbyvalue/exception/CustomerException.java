package com.kagan.callbyvalue.exception;

public class CustomerException extends Exception {

	private static final long serialVersionUID = 1L;
	private String explanation;

	public CustomerException(String explanation) {
		super();
		this.explanation = explanation;
	}
	
}
