package com.cs3750.messages;

public class GameMessage extends Message {
	@Override
	public String toString() {
		return "GameMessage [message=" + message + ", type=" + type + ", username=" + username + ", getMessage()="
				+ getMessage() + ", getType()=" + getType() + ", getUsername()=" + getUsername() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private String message;
	
	public GameMessage(String message) {
		super("game");
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
