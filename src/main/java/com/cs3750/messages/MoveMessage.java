package com.cs3750.messages;

public class MoveMessage extends Message {
	@Override
	public String toString() {
		return "MoveMessage [card=" + card + ", to=" + to + ", username=" + username + ", type=" + type + ", getCard()="
				+ getCard() + ", getTo()=" + getTo() + ", getType()=" + getType() + ", getUsername()=" + getUsername()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	private Integer card;
	private Integer to;
	private String username;
	
	public MoveMessage(Integer card, Integer to) {
		this(null, card, to);
	}
	
	public MoveMessage(String username, Integer card, Integer to) {
		super("move");
		this.card = card;
		this.to = to;
	}
	
	public Integer getCard() {
		return card;
	}
	
	public Integer getTo() {
		return to;
	}
}
