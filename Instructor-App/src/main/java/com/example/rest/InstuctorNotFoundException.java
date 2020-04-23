package com.example.rest;

public class InstuctorNotFoundException extends Throwable {
	private static final long serialVersionUID = 1L;

	String message;

	public InstuctorNotFoundException(String message) {
		super();
		this.message = message;
	}

	public InstuctorNotFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "InstuctorNotFoundException [message=" + message + "]";
	}

	

}