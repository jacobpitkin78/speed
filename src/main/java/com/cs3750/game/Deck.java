package com.cs3750.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck = new ArrayList<Card>();
    private int size;

    public Deck(int n) {
        makeDeck(n);
        size = 52 * n;
    }

    public Deck(List<Card> deck) {
        setDeck(deck);
    }

    public void makeDeck(int n) {

        for (int i = 0; i < n; i++) {
            for (Card.Ranking ranking : Card.Ranking.values()) {
                for (Card.Suit suit : Card.Suit.values()) {
                    deck.add(new Card(suit, ranking));
                }
            }
        }
    }

    public static Deck shuffle(Deck newDeck) {
        List<Card> decks = newDeck.getDeck();
        for (int i = 0; i < decks.size(); i++) {
            Random random = new Random();

            int r = i + random.nextInt(decks.size() - i);

            Card temp = decks.get(r);
            decks.set(r, decks.get(i));
            decks.set(i, temp);
        }

        newDeck.setDeck(decks);
        return newDeck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public Card popDeck() {

        Card card = deck.get(0);
        deck.remove(0);

        return card;
    }

    public static Card popCard(List<Card> cards) {

        Card card = cards.get(0);
        cards.remove(0);

        return card;
    }

    public static void main(String[] args) {
        Deck deck = new Deck(2);
        shuffle(deck);
        System.out.println(deck.getDeck());
    }
}
