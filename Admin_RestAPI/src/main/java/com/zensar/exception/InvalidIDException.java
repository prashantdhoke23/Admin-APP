package com.zensar.exception;

public class InvalidIDException extends RuntimeException {
	private String message;

	public InvalidIDException() {

		this.message = "";
	}

	public InvalidIDException(String message) {

		this.message = message;
	}

	@Override
	public String toString() {

		return "Invalid Credentials :" + this.message;
		

	}

}
