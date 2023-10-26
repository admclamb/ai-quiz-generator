package com.aiquizgenerator.backend.vendors.openai.dtos;

public class MessageDTO {

    private String role;
    private String content;

    public MessageDTO(String role, String prompt) {
        this.role = role;
        this.content =  prompt;
    }

    public String getContent() {
        return content;
    }

    public String getRole() {
        return role;
    }
}