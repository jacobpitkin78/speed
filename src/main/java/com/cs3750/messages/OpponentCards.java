package com.cs3750.messages;

import java.util.List;

public class OpponentCards extends Message {
	private List<Integer> cards;
	
	public OpponentCards(List<Integer> cards) {
		super("opponent");
		this.cards = cards;
	}
	
	public List<Integer> getCards() {
		return cards;
	}
}
