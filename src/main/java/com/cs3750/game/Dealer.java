package com.cs3750.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.cs3750.game.Card.Ranking;

public class Dealer {

    public static int MIDDLE_LIMIT = 2;
    List<Card> middleCur = new ArrayList<Card>();
    List<Card> middleOld = new ArrayList<Card>();
    List<Card> playerOneCards, playerTwoCards;
    List<Card> playedCards = new ArrayList<Card>();
    Deck deck;
    Player playerA, playerB;


    public Dealer(Deck deck) {
        this.deck = deck;
        Deck.shuffle(this.deck);

        playerOneCards = new ArrayList<Card>();
        playerTwoCards = new ArrayList<Card>();

        for (int i = 0; i < MIDDLE_LIMIT; i++) {
            middleCur.add(this.deck.popDeck());
        }
        
        for (Card card: middleCur) {
        	middleOld.add(card);
        }

        halfDeck(this.deck.getDeck(), playerOneCards, playerTwoCards);

        this.playerA = new Player(playerOneCards);
        this.playerB = new Player(playerTwoCards);

    }

    public static void halfDeck(List<Card> cards, List<Card> first, List<Card> second) {

        for (int i = cards.size() - 1; i >= 0 ; i--) {
            if (i % 2 == 0) {
                first.add(cards.remove(cards.size() - 1));
            } else {
                second.add(cards.remove(cards.size() - 1));
            }
        }
    }

    public void replaceMiddleCards() {
        middleCur = new ArrayList<Card>();
        Card temp = this.playerA.popMiddleSide();
        if (temp != null) {
            middleCur.add(temp);
            middleCur.add(this.playerB.popMiddleSide());
        }
    }

    
    
    public List<Card> getMiddleCur() {
		return middleCur;
	}

	public void setMiddleCur(List<Card> middleCur) {
		this.middleCur = middleCur;
	}

	public List<Card> getMiddleOld() {
		return middleOld;
	}

	public void setMiddleOld(List<Card> middleOld) {
		this.middleOld = middleOld;
	}

    public List<Card> getPlayerOneCards() {
        return playerOneCards;
    }

    public void setPlayerOneCards(List<Card> playerOneCards) {
        this.playerOneCards = playerOneCards;
    }

    public List<Card> getPlayerTwoCards() {
        return playerTwoCards;
    }

    public void setPlayerTwoCards(List<Card> playerTwoCards) {
        this.playerTwoCards = playerTwoCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getPlayerAName() {
        return playerA.getName();
    }

    public void setPlayerAName(String name) {
        this.playerA.setName(name); 
    }

    public String getPlayerBName() {
        return playerB.getName();
    }

    public void setPlayerBName(String name) {
        this.playerB.setName(name); 
    }

    public Player getPlayerA() {
		return playerA;
	}

	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	public Player getPlayerB() {
		return playerB;
	}

	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

	// boolean[] can be replaced by a specific type of Message once the Message factory is done.
    public boolean[] playerRequestToCoverCard(Player player, Card cardFromPlayer,
                                            int value ) {
        // results[0]: if there's any change
        // results[1]: if the player is winning.
    	// results[2]: if the middle cards need to be replaced
        boolean[] results = new boolean[3];
        Card target =  new Card(Ranking.values()[value - 1]);
        
        if (middleCur.contains(target)) {
        	if (cardFromPlayer.isNeighbor(target)) {
        		player.removeHandCard(cardFromPlayer);
        		middleCur.remove(target);
        		middleCur.add(cardFromPlayer);
        		results[0] = true;
                if (player.getCardsOnHand().size() == 0 && player.getCardsOnSide().size() == 0) {
                    results[1] = true;
                }
        	}
        }
        
        results[2] = solveStuck();

        return results;
    }

    public boolean solveStuck() {
		
    	for (Card card: playerA.getCardsOnHand()) {
    		if (card.isNeighbor(middleCur.get(0))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    	    	playedCards.add(middleCur.get(0));
    	    	playedCards.add(middleCur.get(1));
    			return false;
    		};
    		if (card.isNeighbor(middleCur.get(1))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    	    	playedCards.add(middleCur.get(0));
    	    	playedCards.add(middleCur.get(1));
    			return false;
    		};
    	}	
    	
    	for (Card card: playerB.getCardsOnHand()) {
    		if (card.isNeighbor(middleCur.get(0))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    	    	playedCards.add(middleCur.get(0));
    	    	playedCards.add(middleCur.get(1));
    			return false;
    		};
    		if (card.isNeighbor(middleCur.get(1))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    	    	playedCards.add(middleCur.get(0));
    	    	playedCards.add(middleCur.get(1));
    			return false;
    		};
    	}
    	
    	middleOld.set(0, middleCur.get(0));
    	middleOld.set(1, middleCur.get(1));
    	playedCards.add(middleCur.get(0));
    	playedCards.add(middleCur.get(1));
    	
    	Card left = getPlayerA().popMiddleSide();
    	Card right = getPlayerB().popMiddleSide();
    	
    	if (left == null && right == null) {
    		System.out.println(playedCards);
    		for (int i = 0; i < playedCards.size(); i++) {
                Random random = new Random();

                int r = i + random.nextInt(playedCards.size() - i);

                Card temp = playedCards.get(r);
                playedCards.set(r, playedCards.get(i));
                playedCards.set(i, temp);
            }
    		
    		for (int i = 0; i < playedCards.size(); i++) {
    			if (i % 2 == 0) {
    				getPlayerA().pushMiddleSide(playedCards.get(i));
    			} else {
    				getPlayerB().pushMiddleSide(playedCards.get(i));
    			}
    		}
    		
    		playedCards.clear();
    		
    		left = getPlayerA().popMiddleSide();
    		right = getPlayerB().popMiddleSide();
    	}
    	
//    	middleCur.set(0, getPlayerA().popMiddleSide());
//    	middleCur.set(1, getPlayerB().popMiddleSide());
    	middleCur.set(0, left);
    	middleCur.set(1, right);
    	
    	return true;
    }
    
    public static void main(String[] args) {

        Deck deck = new Deck(1);
        Dealer dealer = new Dealer(deck);
        System.out.println(dealer.getPlayerA().getCardsOnHand());
        System.out.println(dealer.getPlayerB().getCardsOnHand());
        System.out.println(dealer.getPlayerA().getCardsOnMiddleSide());
        System.out.println(dealer.getPlayerB().getCardsOnMiddleSide());
        System.out.println(dealer.getPlayerA().getCardsOnSide());
        System.out.println(dealer.getPlayerB().getCardsOnSide());
        System.out.println("Deck: " + dealer.getDeck().getDeck());
        dealer.replaceMiddleCards();
        System.out.println(dealer.getPlayerA().getCardsOnMiddleSide());
        System.out.println(dealer.getPlayerB().getCardsOnMiddleSide());
        dealer.replaceMiddleCards();
        dealer.getPlayerA().flipCardToOnHand();
    }
}
