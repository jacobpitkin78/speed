package com.cs3750.messages;

public class ConnectMessage extends Message {
	@Override
	public String toString() {
		return "ConnectMessage [username=" + username + ", type=" + type + ", getUsername()=" + getUsername()
				+ ", getType()=" + getType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	private String username;

	public ConnectMessage(String username) {
		super("connect");
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
}
