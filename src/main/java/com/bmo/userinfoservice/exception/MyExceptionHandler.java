package com.bmo.userinfoservice.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<UserException> userNotFoundException(Exception ex, WebRequest request)
			throws Exception {

		UserException userException = new UserException(ex.getMessage(), LocalDateTime.now(),
				request.getDescription(false));

		return new ResponseEntity<UserException>(userException, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public final ResponseEntity<UserException> userAlreadyExistException(Exception ex, WebRequest request) throws Exception{
		UserException userException = new UserException(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
		
		return new ResponseEntity<UserException>(userException, HttpStatus.CONFLICT);
	}
	

}
