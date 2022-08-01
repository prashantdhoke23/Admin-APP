package com.zensar.exception;

public class InvalidSearchingDataException extends RuntimeException {
	
	private String message;

	public InvalidSearchingDataException() {

		this.message = "";
	}

	public InvalidSearchingDataException(String message) {

		this.message = message;
	}

	@Override
	public String toString() {

		return "Invalid Credentials :" + this.message;
		

	}

}
