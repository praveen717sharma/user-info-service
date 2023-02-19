package com.bmo.userinfoservice.exception;


import java.time.LocalDateTime;

public class UserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private LocalDateTime localDatetime;
	private String discription;
	
	public UserException() {
		super();
	}

	public UserException(String message, LocalDateTime localDatetime, String discription) {
		super();
		this.message = message;
		this.localDatetime = localDatetime;
		this.discription = discription;  
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getLocalDatetime() {
		return localDatetime;
	}

	public void setLocalDatetime(LocalDateTime localDatetime) {
		this.localDatetime = localDatetime;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
