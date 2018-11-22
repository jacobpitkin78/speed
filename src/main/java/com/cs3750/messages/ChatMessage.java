package com.cs3750.messages;

public class ChatMessage extends Message {
	@Override
	public String toString() {
		return "ChatMessage [message=" + message + ", username=" + username + ", type=" + type + ", getMessage()="
				+ getMessage() + ", getUsername()=" + getUsername() + ", getType()=" + getType() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private String message;
	private String username;
	
	public ChatMessage(String message, String username) {
		super("chat");
		this.message = message;
		this.username = username;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getUsername() {
		return username;
	}
}
