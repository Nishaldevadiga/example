package com.sprintDemo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<?> handleResourseNotFOundException(DuplicateUserException exception,WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(InvalidLoginCredentialException.class)
	public ResponseEntity<?> handleResourseNotFOundException(InvalidLoginCredentialException exception,WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<?> handleResourseNotFOundException(NoSuchUserException exception,WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<?> handleResourseNotFOundException(DuplicateCustomerException exception,WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<?> handleResourseNotFOundException(NoSuchCustomerException exception,WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	
}
