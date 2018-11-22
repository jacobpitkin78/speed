package com.cs3750.messages;

public class AckMessage extends Message {
	
	@Override
	public String toString() {
		return "AckMessage [type=" + type + ", username=" + username + ", getType()=" + getType() + ", getUsername()="
				+ getUsername() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public AckMessage() {
		super("Ack");
	}
}
