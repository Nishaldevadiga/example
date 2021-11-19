package com.sprintDemo.exception;

@SuppressWarnings("serial")
public class NoSuchUserException extends Exception {
	public NoSuchUserException(String message) {
		super(message);
	}
}
