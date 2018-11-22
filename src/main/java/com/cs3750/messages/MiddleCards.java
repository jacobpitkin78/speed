package com.cs3750.messages;

import java.util.List;

public class MiddleCards extends Message {
	@Override
	public String toString() {
		return "MiddleCards [cards=" + cards + ", type=" + type + ", username=" + username + ", getCards()="
				+ getCards() + ", getType()=" + getType() + ", getUsername()=" + getUsername() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private List<Integer> cards;
	
	public MiddleCards(List<Integer> cards) {
		super("middle");
		this.cards = cards;
	}
	
	public List<Integer> getCards() {
		return cards;
	}
}
