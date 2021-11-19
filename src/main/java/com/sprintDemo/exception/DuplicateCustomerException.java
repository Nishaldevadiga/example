package com.sprintDemo.exception;

@SuppressWarnings("serial")
public class DuplicateCustomerException extends Exception {
	public DuplicateCustomerException(String message) {
		super(message);
	}
}
