package com.aiquizgenerator.backend.vendors.openai.dtos;

import com.aiquizgenerator.backend.vendors.openai.labels.PromptLabels;

public class PromptDTO {
    private final String prompt;
    private boolean useJsonOutput = false;

    public PromptDTO(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setResponseToJson() {
        useJsonOutput = true;
    }

    public String build() {
        String formattedPrompt = prompt;
        if (useJsonOutput) {
            formattedPrompt += " " + PromptLabels.SET_JSON_OUTPUT;
        }
        return formattedPrompt;
    }
}