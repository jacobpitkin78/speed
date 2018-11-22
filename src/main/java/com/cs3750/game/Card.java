package com.cs3750.game;

public class Card {
    public enum Suit {HEART, SPADE, DIAMOND, CLUB}
    public enum Ranking {A(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
    	NINE(9), TEN(10), J(11), Q(12), K(13);
    	private int value;
    	private Ranking(int value) {
    		this.value = value;
    	}
    	
    	public int getValue() {
    		return this.value;
    	}
    	
    	};
    private Suit suit;
    private Ranking ranking;

    public Card(Suit suit, Ranking ranking) {
        this.suit = suit;
        this.ranking = ranking;
    }
    
    public Card(Ranking ranking) {
        this.ranking = ranking;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public boolean isNeighbor(Card o) {
        int first = getRanking().ordinal();
        int second = o.getRanking().ordinal();
        int diff = Math.abs(first - second);
        if (diff == 1 || diff == 12) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String expression = String.format("Card: %s %s\n", getSuit(), getRanking());
        return expression;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Card)) {
            return false;
        }

        if (!((Card) obj).ranking.equals(this.ranking)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int hashCode = 17;
        hashCode = 31 * hashCode + this.getRanking().hashCode();

        return hashCode;
    }

    public static void main(String[] args) {
        Card card1 = new Card(Suit.HEART, Ranking.A);
        Card card2 = new Card(Suit.CLUB, Ranking.K);
        System.out.println(card1.isNeighbor(card2));
    }
}
