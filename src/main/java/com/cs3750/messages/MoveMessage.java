package com.cs3750.messages;

public class MoveMessage extends Message {
	@Override
	public String toString() {
		return "MoveMessage [from=" + from + ", to=" + to + ", username=" + username + ", type=" + type + ", getFrom()="
				+ getFrom() + ", getTo()=" + getTo() + ", getType()=" + getType() + ", getUsername()=" + getUsername()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	private Integer from;
	private Integer to;
	private String username;
	
	public MoveMessage(String username, Integer from, Integer to) {
		super("move");
		this.from = from;
		this.to = to;
	}
	
	public Integer getFrom() {
		return from;
	}
	
	public Integer getTo() {
		return to;
	}
}
