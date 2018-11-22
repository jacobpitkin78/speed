package com.cs3750.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {

    private List<Card> cardsOnHand;
    private List<Card> cardsOnSide;
    private Stack<Card> cardsOnMiddleSide;
    public static int MIDDLE_SIDE_LIMIT = 5;
    public static int ON_HAND_LIMIT = 5;
    private String name = "";

    public Player(List<Card> card) {
        this.cardsOnSide = card;
        this.cardsOnHand = new ArrayList<Card>();
        this.cardsOnMiddleSide = new Stack<Card>();

        for (int i = 0; i < ON_HAND_LIMIT; i++) {
            this.cardsOnHand.add(Deck.popCard(cardsOnSide));
        }

        for (int i = 0; i < MIDDLE_SIDE_LIMIT; i++) {
            this.cardsOnMiddleSide.push(Deck.popCard(cardsOnSide));
        }
    }

    public List<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    public void setCardsOnHand(List<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public List<Card> getCardsOnSide() {
        return cardsOnSide;
    }

    public void setCardsOnSide(List<Card> cardsOnSide) {
        this.cardsOnSide = cardsOnSide;
    }

    public Stack<Card> getCardsOnMiddleSide() {
        return cardsOnMiddleSide;
    }

    public void setCardsOnMiddleSide(Stack<Card> cardsOnMiddleSide) {
        this.cardsOnMiddleSide = cardsOnMiddleSide;
    }

    public void flipCardToOnHand() {

        while (getCardsOnSide().size() <= 0
                || getCardsOnHand().size() >= ON_HAND_LIMIT) {

            this.cardsOnHand.add(getCardsOnSide().get(0));
            this.cardsOnSide.remove(0);
        }
    }

    public Card popMiddleSide() {
        if (getCardsOnMiddleSide().size() == 0) {
            return null;
        }

        return getCardsOnMiddleSide().pop();
    }

    public Card requestToPlaceCard(Card card) {
        if (cardsOnHand.contains(card)) {
            return card;
        }

        return null;
    }

    public void removeHandCard(Card card) {
        if (cardsOnHand.contains(card)) {
            cardsOnHand.remove(card);
        }
    }

    public boolean isWin() {
        return (cardsOnHand.size() + cardsOnSide.size()) == 0;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
        Deck deck = new Deck(2);
//        Deck.shuffle(deck);
        Player player = new Player(deck.getDeck());
        System.out.println(player.getCardsOnHand());
        System.out.println(player.getCardsOnSide());
        player.removeHandCard(new Card(Card.Suit.HEART, Card.Ranking.TWO));
        player.flipCardToOnHand();
        System.out.println(player.getCardsOnHand());
        System.out.println(player.getCardsOnSide());
        System.out.println(player.getCardsOnMiddleSide());
    }
}
