package com.cs3750.game;

import java.util.ArrayList;
import java.util.List;

import com.cs3750.game.Card.Ranking;
import com.cs3750.messages.AckMessage;
import com.cs3750.messages.ComplementHandCardsMessage;
import com.cs3750.messages.ConnectMessage;
import com.cs3750.messages.InvalidMessage;
import com.cs3750.messages.Message;
import com.cs3750.messages.MoveMessage;
import com.cs3750.messages.ResultsMessage;
import com.cs3750.messages.StartMessage;

public class GameHandler {
	
	private static GameHandler game = null;
	private static Dealer dealer;
	private static Deck deck;
	private static boolean started = false;
	
	public GameHandler() {
        deck = new Deck(1);
        dealer = new Dealer(deck);
	}
	
	public static Message messageIn(Message msg) {
		
		if (msg instanceof StartMessage) {
			if (game.getDealer().getPlayerBName().equals("")) {
				
				return new InvalidMessage("Not enough players");
			} else if (started) {
				return new InvalidMessage("Already started");
			} else {
				started = true;
				
				return new StartMessage();
			}
		}
		// StartMessage needs to contain cards info
		
		if (msg instanceof ConnectMessage) {
			if (game == null) {
				game = new GameHandler();
			} 
			
			if (game.getDealer().getPlayerAName().equals("")) {
				game.getDealer().setPlayerAName(((ConnectMessage) msg).getUsername());
				
				return new AckMessage();
			} else if (game.getDealer().getPlayerBName().equals("")) {
				
				if (((ConnectMessage) msg).getUsername().equals(game.getDealer().getPlayerAName())) {
					
					return new InvalidMessage("Duplicated username.");
				}
				
				game.getDealer().setPlayerBName(((ConnectMessage) msg).getUsername());
				
				started = true;
				
				return new StartMessage(cardIntConverter(game.getDealer().getPlayerA().getCardsOnHand()),cardIntConverter(game.getDealer().getPlayerB().getCardsOnHand()), cardIntConverter(game.getDealer().getMiddleCur()));
			
			} else {
				
				return new InvalidMessage("No slot.");
			}
		}
		
		if (msg instanceof MoveMessage) {
			String username = msg.getUsername();
			
			if (game == null || game.getDealer().getPlayerBName().equals("") || started == false) {
				
				return new InvalidMessage("No game started");
			} else {
				if (username.equals(game.getDealer().getPlayerAName())) {
					Player player = game.getDealer().getPlayerA();
					Card from = new Card(Ranking.values()[((MoveMessage) msg).getFrom() - 1]);
					boolean[] results = game.getDealer().playerRequestToCoverCard(player, from, ((MoveMessage) msg).getTo());
					
					if (username.equals(dealer.getPlayerAName())) {
						
						return new ResultsMessage(username, results, cardIntConverter(dealer.getMiddleCur()), cardIntConverter(dealer.getMiddleOld()),
								cardIntConverter(dealer.getPlayerA().getCardsOnHand()), cardIntConverter(dealer.getPlayerB().getCardsOnHand()),
								dealer.getPlayerA().getCardsOnSide().size(), dealer.getPlayerB().getCardsOnSide().size());
					} else if (username.equals(dealer.getPlayerBName())) {
						
						return new ResultsMessage(username, results, cardIntConverter(dealer.getMiddleCur()), cardIntConverter(dealer.getMiddleOld()),
								cardIntConverter(dealer.getPlayerB().getCardsOnHand()), cardIntConverter(dealer.getPlayerA().getCardsOnHand()),
								dealer.getPlayerB().getCardsOnSide().size(), dealer.getPlayerA().getCardsOnSide().size());
					}
				}
			}
		}
		
		if (msg instanceof ComplementHandCardsMessage) {
			
			if (!started) {
				return new InvalidMessage("No game started.");
			}
			
			
			String username = msg.getUsername();
			
			if (username.equals(dealer.getPlayerAName())) {
				dealer.getPlayerA().flipCardToOnHand();
				
				return new ComplementHandCardsMessage(username, cardIntConverter(dealer.getPlayerA().getCardsOnHand()),
						dealer.getPlayerA().getCardsOnSide().size());
				
			} else if (username.equals(dealer.getPlayerBName())) {
				dealer.getPlayerB().flipCardToOnHand();
				
				return new ComplementHandCardsMessage(username, cardIntConverter(dealer.getPlayerB().getCardsOnHand()),
						dealer.getPlayerB().getCardsOnSide().size());
			}
			
		}
		
		return new InvalidMessage("Invalid");
	}

	public static List<Integer> cardIntConverter(List<Card> cards) {
		
		List<Integer> nums = new ArrayList<Integer>();
		for (Card card:cards) {
			nums.add(card.getRanking().getValue());
		}
		
		return nums;
	}
	
	public static Dealer getDealer() {
		return dealer;
	}

	public static void setDealer(Dealer dealer) {
		GameHandler.dealer = dealer;
	}

	public static Deck getDeck() {
		return deck;
	}

	public static void setDeck(Deck deck) {
		GameHandler.deck = deck;
	}

	public static void main(String[] args) {
		System.out.println(messageIn(new ConnectMessage("a")));
		System.out.println(GameHandler.getDealer().getPlayerAName());
		System.out.println(messageIn(new ConnectMessage("a")));
		System.out.println(messageIn(new ConnectMessage("b")));
		System.out.println(messageIn(new StartMessage()));
		System.out.println(messageIn(new MoveMessage("a", 2, 3)));


	}
}
