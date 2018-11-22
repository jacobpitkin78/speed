package com.cs3750.messages;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

public class MessageFactory {
	
	public static String getAckMessage() {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "ack");
		
		return objBuilder.build().toString();
	}
	
	public String getConnectMessage(ConnectMessage connectMessage) {
		return getConnectMessage(connectMessage.getUsername());
	}
	
	public static String getConnectMessage(String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "connect");
		objBuilder.add("username", username);
		
		return objBuilder.build().toString();
	}
	
	public static String getDrawMessage(DrawMessage drawMessage) {
		return getDrawMessage();
	}
	
	public static String getDrawMessage() {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "draw");
		
		return objBuilder.build().toString();
	}
	
	public static String getMoveMessage(MoveMessage moveMessage) {
		return getMoveMessage(moveMessage.getFrom(), moveMessage.getTo());
	}
	
	public static String getMoveMessage(int from, int to) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "move");
		objBuilder.add("from", from);
		objBuilder.add("to", to);
		
		return objBuilder.build().toString();
	}
	
	public static String getCardMessage(CardMessage cardMessage) {
		return getCardMessage(cardMessage.getCard());
	}
	
	public static String getCardMessage(int card) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "card");
		objBuilder.add("card", card);
		
		return objBuilder.build().toString();
	}
	
	public static String getChatMessage(ChatMessage chatMessage) {
		return getChatMessage(chatMessage.getMessage(), chatMessage.getUsername());
	}
	
	public static String getChatMessage(String message, String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "chat");
		objBuilder.add("username", username);
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public static String getGameMessage(GameMessage gameMessage) {
		return getGameMessage(gameMessage.getMessage());
	}
	
	public static String getGameMessage(String message) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "game");
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public static String getInvalidMessage(InvalidMessage invalidMessage) {
		return getInvalidMessage(invalidMessage.getMessage());
	}
	
	public static String getInvalidMessage(String message) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "invalid");
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public String getMiddleCards(MiddleCards middleCards) {
		return getMiddleCards(middleCards.getCards());
	}
	
	public static String getMiddleCards(List<Integer> cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "middle");
		
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		
		for (int i : cards) {
			arrBuilder.add(Json.createObjectBuilder().add("card", i));
		}
		
		objBuilder.add("cards", arrBuilder);
		
		return objBuilder.build().toString();
	}
	
	public static String getOpponentCards(OpponentCards opponentCards) {
		return getOpponentCards(opponentCards.getCards());
	}
	
	public static String getOpponentCards(List<Integer> cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "opponent");
		objBuilder.add("cards", cards.size());
		
		return objBuilder.build().toString();
	}
	
	public static String getPlayerCards(PlayerCards playerCards) {
		return getPlayerCards(playerCards.getCards());
	}
	
	public static String getPlayerCards(List<Integer> cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "player");
		
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		
		for (int i : cards) {
			arrBuilder.add(Json.createObjectBuilder().add("card", i));
		}
		
		objBuilder.add("cards", arrBuilder);
		
		return objBuilder.build().toString();
	}
	
	public static String getResultsMessage() {
		return null;
	}
	
	public static String getStartMessage(StartMessage startMessage) {
		return getStartMessage(startMessage.getUsername());
	}
	
	public static String getStartMessage(String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "start");
		objBuilder.add("username", username);
		
		return objBuilder.build().toString();
	}
	
	public static String getStuckMessage() {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "stuck");
		
		return objBuilder.build().toString();
	}
	
	public static Message parse(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
    	String type = reader.readObject().getString("type");
    	
    	if (type.equals("ack")) {
    		return new AckMessage();
    	} else if (type.equals("card")) {
    		return new CardMessage(reader.readObject().getInt("card"));
    	} else if (type.equals("chat")) {
    		return new ChatMessage(reader.readObject().getString("message"), reader.readObject().getString("username"));
    	} else if (type.equals("complementHandCards")) {
    		// Need to build function
    	} else if (type.equals("connect")) {
    		return new ConnectMessage(reader.readObject().getString("username"));
    	} else if (type.equals("draw")) {
    		return new DrawMessage();
    	} else if (type.equals("game")) {
    		return new GameMessage(reader.readObject().getString("message"));
    	} else if (type.equals("invalid")) {
    		return new InvalidMessage(reader.readObject().getString("message"));
    	} else if (type.equals("move")) {
    		return new MoveMessage(reader.readObject().getString("username"), reader.readObject().getInt("from"), reader.readObject().getInt("to"));
    	} else if (type.equals("opponentCards")) {
    		List<Integer> cards = new ArrayList<Integer>();
    		
    		for (int i = 0; i < reader.readArray().size(); i++) {
    			cards.add(reader.readArray().getInt(i));
    		}
    		
    		return new OpponentCards(cards);
    	} else if (type.equals("playerCards")) {
    		List<Integer> cards = new ArrayList<Integer>();
    		
    		for (int i = 0; i < reader.readArray().size(); i++) {
    			cards.add(reader.readArray().getInt(i));
    		}
    		
    		return new PlayerCards(cards);
    	} else if (type.equals("result")) {
    		
    	} else if (type.equals("start")) {
    		return new StartMessage();
    	} else {
    		// Probably throw error, since no other message exists
    	}
    	
    	return null;
	}
}
