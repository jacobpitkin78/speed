package com.cs3750.messages;

public class InvalidMessage extends Message {
	@Override
	public String toString() {
		return "InvalidMessage [message=" + message + ", type=" + type + ", username=" + username + ", getMessage()="
				+ getMessage() + ", getType()=" + getType() + ", getUsername()=" + getUsername() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private String message;
	
	public InvalidMessage(String message) {
		super("invalid");
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
