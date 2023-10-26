package com.aiquizgenerator.backend.vendors.openai.dtos;

import java.util.ArrayList;
import java.util.List;

public class ChatRequestDTO {
    private String model;
    private List<MessageDTO> messages;
    private int n;
    private double temperature;

    public ChatRequestDTO(String model, String prompt) {
        this.model = model;

        this.messages = new ArrayList<>();
        this.messages.add(new MessageDTO("user", prompt));
    }

    public String getModel() {
        return model;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public int getN() {
        return n;
    }

    public double getTemperature() {
        return temperature;
    }
}