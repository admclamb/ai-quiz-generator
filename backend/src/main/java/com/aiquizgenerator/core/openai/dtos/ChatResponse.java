package com.aiquizgenerator.core.openai.dtos;

import java.util.List;

public class ChatResponse {
    private List<Choice> choices;

    public static class Choice {

        private int index;
        private Message message;
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
