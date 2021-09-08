package com.example.hr.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.example.hr.domain.event.DomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventPublisherWebSocketService implements WebSocketHandler {
	protected List<WebSocketSession> sessions = Collections.synchronizedList(new ArrayList<>());
	private ObjectMapper objectMapper;

	public EventPublisherWebSocketService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@EventListener
	public void publish(DomainEvent domainEvent) throws Exception {
		var json = objectMapper.writeValueAsString(domainEvent);
		for (var session : sessions)
			session.sendMessage(new TextMessage(json));
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		WebSocketSession removeSession = null;
		for (var s : sessions) {
			if (s.getId().equals(session.getId())) {
				removeSession = s;
				break;
			}
		}
		if (Objects.nonNull(removeSession))
			sessions.remove(removeSession);
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
