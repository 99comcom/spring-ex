package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	List<WebSocketSession> sessions=new ArrayList<>();
	

	//웹소켓 연결이 끊어졌을때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		sessions.remove(session);
		System.out.println("끊김"+session.getId());
	}

	//클라이언트가 연결 되었을 때 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		sessions.add(session);
		System.out.println("연결"+session.getId());
	}

	//클라이언트가 웹소켓 서버로 메세지를 전송했을 때 
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
	}
	
	
	
	
	
}
