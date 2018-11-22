package com.cs3750.messages;

public class Message {
	protected String type;
	String username;
	
	public Message(String username) {
		this.username = username;
	}
	
	public Message(String username, String type) {
		this.type = type;
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
