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
	private static ArrayList<Client> connections = new ArrayList<Client>();
	private static int starts = 0;
	private static GameHandler game;
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen::" + session.getId());
        System.out.println(connections.size());
        
        if (connections.size() < 2) {
        	connections.add(new Client(session));
        }
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose::" +  session.getId());
        connections.remove(session);
        
        if (!connections.isEmpty()) {
        	try {
				connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getGameMessage("Congratulations, you won due to a forfeit!"));
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    @SuppressWarnings("static-access")
	@OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("onMessage::From=" + session.getId() + " Message=" + message);
        Message incoming = MessageFactory.parse(message);
        
//        if (incoming instanceof ConnectMessage) {
//        	starts++;
//        	System.out.println("Starts: " + starts);
//        	
//        	if (starts == 2) {
//        		System.out.println("should start");
//        		game = new GameHandler();
//        	}
//        }
        
//        if (game == null || connections.size() < 2) {
//        	System.out.println("returning");
//        	return;
//        }
        
        if (game == null) {
        	game = new GameHandler();
        }
        
        if (incoming instanceof ConnectMessage) {
        	ConnectMessage conMessage = (ConnectMessage) incoming;
        	
        	for (Client c : connections) {
        		if (c.getSession().equals(session)) {
        			c.setUsername(conMessage.getUsername());
        			System.out.println(conMessage.getUsername());
        		}
        	}
        }
        
        Message returnMessage = game.messageIn(incoming);
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
            			connections.get(1).getSession().getBasicRemote().sendText("You lost!");
            		} else {
            			connections.get(0).getSession().getBasicRemote().sendText("You lost!");
            		}
            	} else if (results.isStuck()) {
            		connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getStuckMessage());
            		connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getStuckMessage());
            		
            		long start = System.currentTimeMillis();
            		
            		while (3000 > System.currentTimeMillis() - start) {
            			// waiting for 3 seconds to send the middles
            		}
            		
            		connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            		connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            	} else if (results.isMoved()) {
            		connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            		connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getMiddleCards(results.getMiddlesAfter()));
            		connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getPlayerCards(results.getPlayerACards()));
            		connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getPlayerCards(results.getPlayerBCards()));
            		connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getOpponentCards(results.getPlayerBCards()));
            		connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getOpponentCards(results.getPlayerACards()));
            	}
            } else if (returnMessage instanceof ConnectMessage) {
            	session.getBasicRemote().sendText(MessageFactory.getConnectMessage((ConnectMessage)returnMessage));
            } else if (returnMessage instanceof StartMessage) {
            	System.out.println("StartMessage");
            	StartMessage start = (StartMessage)returnMessage;
            	
            	connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getOpponentCards(start.getPlayerBOnHand()));
            	connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getOpponentCards(start.getPlayerAOnHand()));
            	connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getMiddleCards(start.getMiddle()));
            	connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getMiddleCards(start.getMiddle()));
            	connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getPlayerCards(start.getPlayerAOnHand()));
            	connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getPlayerCards(start.getPlayerBOnHand()));
            	connections.get(0).getSession().getBasicRemote().sendText(MessageFactory.getStartMessage(connections.get(1).getUsername()));
            	connections.get(1).getSession().getBasicRemote().sendText(MessageFactory.getStartMessage(connections.get(0).getUsername()));
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println("onError::" + t.getMessage());
    }
    
    private class Client {
    	private Session session;
    	private String username;
    	
    	public Client(Session session) {
    		this(session, null);
    	}
    	
    	public Client(Session session, String username) {
    		this.session = session;
    		this.username = username;
    	}
    	
    	public void setUsername(String username) {
    		this.username = username;
    	}
    	
    	public Session getSession() {
    		return session;
    	}
    	
    	public String getUsername() {
    		return username;
    	}
    }
}
