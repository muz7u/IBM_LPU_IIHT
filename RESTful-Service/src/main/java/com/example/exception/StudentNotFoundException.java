package com.example.exception;

public class StudentNotFoundException extends Throwable {
	String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	@Override
	public String toString() {
		return "StudentNotFoundException [messege=" + messege + "]";
	}

	public StudentNotFoundException(String messege) {
		super();
		this.messege = messege;
	}
	
}
