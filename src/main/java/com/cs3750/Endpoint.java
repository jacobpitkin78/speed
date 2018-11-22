package com.cs3750;

import java.io.IOException;
import java.util.ArrayList;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.cs3750.game.*;
import com.cs3750.messages.*;

@ServerEndpoint("/game")
public class Endpoint {
	private ArrayList<Session> connections = new ArrayList<Session>();
	private GameHandler game;
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen::" + session.getId()); 
        
        if (connections.size() < 2) {
        	connections.add(session);
        }
        
        if (connections.size() == 2) {
        	game = new GameHandler();
        }
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose::" +  session.getId());
        connections.remove(session);
        
        if (!connections.isEmpty()) {
        	try {
				connections.get(0).getBasicRemote().sendText(MessageFactory.getGameMessage("Congratulations, you won due to a forfeit!"));
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    @SuppressWarnings("static-access")
	@OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("onMessage::From=" + session.getId() + " Message=" + message);
        
        Message returnMessage = game.messageIn(MessageFactory.parse(message));
        try {
        	if (returnMessage instanceof AckMessage) {
        		session.getBasicRemote().sendText(MessageFactory.getAckMessage());
            } else if (returnMessage instanceof ChatMessage) {
            	session.getBasicRemote().sendText(MessageFactory.getChatMessage((ChatMessage)returnMessage));
            } else if (returnMessage instanceof GameMessage) {
            	session.getBasicRemote().sendText(MessageFactory.getGameMessage((GameMessage)returnMessage));
            } else if (returnMessage instanceof InvalidMessage) {
            	session.getBasicRemote().sendText(MessageFactory.getInvalidMessage((InvalidMessage)returnMessage));
            } else if (returnMessage instanceof ResultsMessage) {
            	ResultsMessage results = (ResultsMessage)returnMessage;
            	
            	if (results.isWin()) {
            		session.getBasicRemote().sendText("Contratulations, you won!");
            		
            		if (connections.indexOf(session) == 0) {
            			connections.get(1).getBasicRemote().sendText("You lost!");
            		} else {
            			connections.get(0).getBasicRemote().sendText("You lost!");
            		}
            	} else if (results.isStuck()) {
            		connections.get(0).getBasicRemote().sendText(MessageFactory.getStuckMessage());
            		connections.get(1).getBasicRemote().sendText(MessageFactory.getStuckMessage());
            		
            		long start = System.currentTimeMillis();
            		
            		while (3000 > System.currentTimeMillis() - start) {
            			// waiting for 3 seconds to send the middles
            		}
            		
            		connections.get(0).getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            		connections.get(0).getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            	} else if (results.isMoved()) {
            		connections.get(0).getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            		connections.get(1).getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            		connections.get(0).getBasicRemote().sendText(MessageFactory.getPlayerCards(results.getPlayerACards()));
            		connections.get(1).getBasicRemote().sendText(MessageFactory.getPlayerCards(results.getPlayerBCards()));
            		connections.get(0).getBasicRemote().sendText(MessageFactory.getOpponentCards(results.getPlayerBCards()));
            		connections.get(1).getBasicRemote().sendText(MessageFactory.getOpponentCards(results.getPlayerACards()));
            	}
            } else if (returnMessage instanceof StartMessage) {
            	session.getBasicRemote().sendText(MessageFactory.getStartMessage((StartMessage)returnMessage));
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println("onError::" + t.getMessage());
    }
}
