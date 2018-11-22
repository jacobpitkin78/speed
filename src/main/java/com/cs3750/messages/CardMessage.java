package com.cs3750.messages;

public class CardMessage extends Message {
	@Override
	public String toString() {
		return "CardMessage [card=" + card + ", type=" + type + ", username=" + username + ", getCard()=" + getCard()
				+ ", getType()=" + getType() + ", getUsername()=" + getUsername() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private Integer card;
	
	public CardMessage(Integer card) {
		super("card");
		this.card = card;
	}
	
	public Integer getCard() {
		return card;
	}
}
