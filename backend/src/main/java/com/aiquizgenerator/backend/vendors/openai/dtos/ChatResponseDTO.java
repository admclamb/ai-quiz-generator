package com.aiquizgenerator.backend.vendors.openai.dtos;

import java.util.List;

public class ChatResponseDTO {
    private List<Choice> choices;

    public static class Choice {

        private int index;
        private MessageDTO message;

        public MessageDTO getMessage() {
            return message;
        }
    }

    public List<Choice> getChoices() {
        return choices;
    }
}