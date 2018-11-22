package com.cs3750.messages;

import java.util.List;

public class PlayerCards extends Message {
	private List<Integer> cards;
	
	public PlayerCards(List<Integer> cards) {
		super("player");
		this.cards = cards;
	}
	
	public List<Integer> getCards() {
		return cards;
	}
}
