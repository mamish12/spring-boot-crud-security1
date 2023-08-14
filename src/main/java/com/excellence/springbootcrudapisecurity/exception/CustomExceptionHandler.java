package com.excellence.springbootcrudapisecurity.exception;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//add


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler(UserDataAccessException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserDataAccessException accessException, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(accessException.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Record Not Found", details);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Server Error", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException argumentNotValidException,
			HttpHeaders  headers,HttpStatus status,WebRequest request)
	{
		
		List<String> details=new ArrayList<>();
		for(ObjectError error:argumentNotValidException.getBindingResult().getAllErrors())
		{
			details.add(error.getDefaultMessage());
		}
		ErrorResponse errorResponse=new ErrorResponse("validation failed", details);
		return new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
