package com.sprintDemo.exception;

@SuppressWarnings("serial")
public class InvalidLoginCredentialException extends Exception {
	public InvalidLoginCredentialException(String message) {
		super(message);
	}
}

