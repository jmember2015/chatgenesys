package com.genesys.chat.controllers;

import com.genesys.chat.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WSChatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSChatController.class);

    @MessageMapping("/push")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {

        LOGGER.debug("Message from: " + message.getSender());
        return message;
    }

    @MessageMapping("/join")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {


        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;

    }

}