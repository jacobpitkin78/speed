package com.cs3750.messages;

import java.util.List;

public class ResultsMessage extends Message{

	private boolean isWin;
	private boolean isMoved;
	private boolean isStuck;
	private List<Integer> middlesOld;
	private List<Integer> middlesCur;
	private List<Integer> playerACards;
	private List<Integer> playerBCards;
	private Integer onSideA;
	private Integer onSideB;

	public ResultsMessage(String username, boolean[] results, List<Integer> middlesCur, List<Integer> middlesOld, 
			List<Integer> playerACards, List<Integer> playerBCards, Integer onSideA, Integer onSideB) {
		super(username);
		this.isWin = results[0];
		this.isMoved = results[1];
		this.isStuck = results[2];
		this.middlesOld = middlesOld;
		this.middlesCur = middlesCur;
		this.playerACards = playerACards;
		this.playerBCards = playerBCards;
		this.onSideA = onSideA;
		this.onSideB = onSideB;
	}
	
	@Override
	public String toString() {
		return "ResultsMessage [isWin=" + isWin + ", isMoved=" + isMoved + ", isStuck=" + isStuck + ", middlesOld="
				+ middlesOld + ", middlesCur=" + middlesCur + ", playerACards=" + playerACards + ", playerBCards="
				+ playerBCards + ", onSideA=" + onSideA + ", onSideB=" + onSideB + ", type=" + type + ", username="
				+ username + ", isWin()=" + isWin() + ", getMiddles()=" + getMiddles() + ", getPlayerACards()="
				+ getPlayerACards() + ", getPlayerBCards()=" + getPlayerBCards() + ", getOnSideA()=" + getOnSideA()
				+ ", getOnSideB()=" + getOnSideB() + ", isMoved()=" + isMoved() + ", isStuck()=" + isStuck()
				+ ", getMiddlesAfter()=" + getMiddlesAfter() + ", getType()=" + getType() + ", getUsername()="
				+ getUsername() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public boolean isWin() {
		return isWin;
	}
	
	public List<Integer> getMiddles() {
		return middlesOld;
	}
	
	public void setMiddles(List<Integer> middles) {
		this.middlesOld = middles;
	}

	public List<Integer> getPlayerACards() {
		return playerACards;
	}

	public void setPlayerACards(List<Integer> playerACards) {
		this.playerACards = playerACards;
	}

	public List<Integer> getPlayerBCards() {
		return playerBCards;
	}

	public void setPlayerBCards(List<Integer> playerBCards) {
		this.playerBCards = playerBCards;
	}

	public Integer getOnSideA() {
		return onSideA;
	}

	public void setOnSideA(Integer onSideA) {
		this.onSideA = onSideA;
	}

	public Integer getOnSideB() {
		return onSideB;
	}

	public void setOnSideB(Integer onSideB) {
		this.onSideB = onSideB;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public boolean isMoved() {
		return isMoved;
	}

	public void setMoved(boolean isMoved) {
		this.isMoved = isMoved;
	}

	public boolean isStuck() {
		return isStuck;
	}

	public void setStuck(boolean isStuck) {
		this.isStuck = isStuck;
	}

	public List<Integer> getMiddlesAfter() {
		return middlesCur;
	}

	public void setMiddlesAfter(List<Integer> middlesAfter) {
		this.middlesCur = middlesAfter;
	}
	
	
}
