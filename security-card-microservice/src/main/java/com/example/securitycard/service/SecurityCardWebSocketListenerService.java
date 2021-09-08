package com.example.securitycard.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

@Service
public class SecurityCardWebSocketListenerService implements WebSocketHandler {
	@Value("${webSocketUrl}")
	private String webSocketUrl;

	private WebSocketClient webSocketClient;

	public SecurityCardWebSocketListenerService(WebSocketClient webSocketClient) {
		this.webSocketClient = webSocketClient;
	}

	@PostConstruct
	public void connectToBinance() {
		webSocketClient.doHandshake(this, webSocketUrl);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.err.println("Connected to the hr microservice server!");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.err.println("New event has arrived through websocket: "+message.getPayload().toString());
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable e) throws Exception {
		System.err.println("An error has occured in session (" + session.getId() + "): " + e.getMessage());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.err.println("Disconnected from the hr microservice server!");
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}
