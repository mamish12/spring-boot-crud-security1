package com.excellence.springbootcrudapisecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//add
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserDataAccessException extends Exception{
	
	private static final long serialVersionUID = -4798965926484615958L;
	
	public UserDataAccessException(String errorMessage)
	{
		super(errorMessage);
	}
	

}
