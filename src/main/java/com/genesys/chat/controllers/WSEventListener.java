package com.genesys.chat.controllers;

import com.genesys.chat.model.Message;
import com.genesys.chat.model.UserChatStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WSEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSEventListener.class);

    private final SimpMessageSendingOperations messagingTemplate;

    @Autowired
    public WSEventListener(SimpMessageSendingOperations messagingTemplate) {

        this.messagingTemplate = messagingTemplate;

    }

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {

        LOGGER.info("Init new WebSocket connection!");

    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            LOGGER.info("User Disconnected : " + username);

            Message chatMessage = new Message();
            chatMessage.setType(UserChatStatus.LEAVE);
            chatMessage.setSender(username);

            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }

    }


}
