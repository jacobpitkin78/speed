package com.cs3750.messages;

import java.util.List;

public class StartMessage extends Message {
	
	private List<Integer> playerAOnHand, playerBOnHand, middle;
	private Integer onSide;
	

	public StartMessage(List<Integer> playerAOnHand, List<Integer> playerBOnHand,
			List<Integer> middle, Integer onSide) {
		super("start");
		this.playerAOnHand = playerAOnHand;
		this.playerBOnHand = playerBOnHand;
		this.middle = middle;
		this.onSide = onSide;
	}

	public StartMessage() {
		super("start");
	}
	
	public String getUsername() {
		return username;
	}
	
	public List<Integer> getPlayerAOnHand() {
		return playerAOnHand;
	}

	public void setPlayerAOnHand(List<Integer> playerAOnHand) {
		this.playerAOnHand = playerAOnHand;
	}

	public List<Integer> getPlayerBOnHand() {
		return playerBOnHand;
	}

	public void setPlayerBOnHand(List<Integer> playerBOnHand) {
		this.playerBOnHand = playerBOnHand;
	}

	public List<Integer> getMiddle() {
		return middle;
	}

	public void setMiddle(List<Integer> middle) {
		this.middle = middle;
	}
	
	public Integer getOnSide() {
		return onSide;
	}
	
	public void setOnSide(Integer onSide) {
		this.onSide = onSide;
	}

	@Override
	public String toString() {
		return "StartMessage [playerAOnHand=" + playerAOnHand + ", playerBOnHand=" + playerBOnHand + ", middle="
				+ middle + ", type=" + type + ", username=" + username + ", getUsername()=" + getUsername()
				+ ", getPlayerAOnHand()=" + getPlayerAOnHand() + ", getPlayerBOnHand()=" + getPlayerBOnHand()
				+ ", getMiddle()=" + getMiddle() + ", onSide=" + onSide + ", getType()=" + getType() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
