package com.company.api.exception;

public class CustomerApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerApiException(String errorMessage, Exception e) {
		super(errorMessage, e);
	}

	public CustomerApiException(String errorMessage) {
		super(errorMessage);
	}
}
