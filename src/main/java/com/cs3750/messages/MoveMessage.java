package com.cs3750.messages;

public class MoveMessage extends Message {
	@Override
	public String toString() {
		return "MoveMessage [card=" + card + ", to=" + to + ", username=" + username + ", type=" + type + ", getCard()="
				+ getCard() + ", getTo()=" + getTo() + ", getType()=" + getType() + ", getUsername()=" + getUsername()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	private int card;
	private int to;
	private String username;
	
	public MoveMessage(int card, int to) {
		this(null, card, to);
	}
	
	public MoveMessage(String username, int card, int to) {
		super("move");
		this.card = card;
		this.to = to;
		this.username = username;
	}
	
	public int getCard() {
		return card;
	}
	
	public int getTo() {
		return to;
	}
	
	public String getUsername() {
		return username;
	}
}
