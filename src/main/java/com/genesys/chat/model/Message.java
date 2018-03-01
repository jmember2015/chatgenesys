package com.genesys.chat.model;

import org.springframework.stereotype.Component;

@Component
public class Message {

    private UserChatStatus type;
    private String content;
    private String sender;

    public UserChatStatus getType() {
        return type;
    }

    public void setType(UserChatStatus type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
