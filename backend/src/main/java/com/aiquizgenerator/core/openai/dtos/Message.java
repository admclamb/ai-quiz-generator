package com.aiquizgenerator.core.openai.dtos;

public class Message {

    private String role;
    private String content;

    public Message(String role, String prompt) {
        this.role = role;
        this.content =  prompt;
    }
}
