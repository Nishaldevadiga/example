package com.sprintDemo.exception;

@SuppressWarnings("serial")
public class DuplicateUserException extends Exception {
	String message;
	public DuplicateUserException(String message) {
		super(message);
	}

}
