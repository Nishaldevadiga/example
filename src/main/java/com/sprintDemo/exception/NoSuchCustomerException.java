package com.sprintDemo.exception;

@SuppressWarnings("serial")
public class NoSuchCustomerException extends  RuntimeException {
	public NoSuchCustomerException(String message) {
		super(message);
	}
}
