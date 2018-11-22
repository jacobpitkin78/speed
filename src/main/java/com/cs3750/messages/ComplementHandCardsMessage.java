package com.cs3750.messages;

import java.util.List;

import com.cs3750.game.Card;

public class ComplementHandCardsMessage extends Message {

	private List<Integer> playerOnHandCards;
	private int playerOnSideCardNum;
	
	public ComplementHandCardsMessage(String username) {
		super(username);
	}

	public ComplementHandCardsMessage(String username, List<Integer> playerOnHandCards, int playerOnSideCardNum) {
		super(username);
		this.playerOnHandCards = playerOnHandCards;
		this.playerOnSideCardNum = playerOnSideCardNum;
	}

	@Override
	public String toString() {
		return "ComplementHandCardsMessage [playerOnHandCards=" + playerOnHandCards + ", playerOnSideCardNum="
				+ playerOnSideCardNum + ", type=" + type + ", username=" + username + ", getPlayerOnHandCards()="
				+ getPlayerOnHandCards() + ", getPlayerOnSideCardNum()=" + getPlayerOnSideCardNum() + ", getType()="
				+ getType() + ", getUsername()=" + getUsername() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public List<Integer> getPlayerOnHandCards() {
		return playerOnHandCards;
	}

	public void setPlayerOnHandCards(List<Integer> playerOnHandCards) {
		this.playerOnHandCards = playerOnHandCards;
	}

	public int getPlayerOnSideCardNum() {
		return playerOnSideCardNum;
	}

	public void setPlayerOnSideCardNum(int playerOnSideCardNum) {
		this.playerOnSideCardNum = playerOnSideCardNum;
	}
	
	
}
