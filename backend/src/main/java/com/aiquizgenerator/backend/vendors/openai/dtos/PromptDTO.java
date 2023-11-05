package com.aiquizgenerator.backend.vendors.openai.dtos;

import com.aiquizgenerator.backend.vendors.openai.labels.PromptLabels;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PromptDTO {

    @NotBlank(message = PromptLabels.PROMPT_NOT_EMPTY)
    @Size(max = 100, message = PromptLabels.MAX_PROMPT_SIZE)
    private String prompt;
    private boolean useJsonOutput = false;

    public String getPrompt() {
        return prompt;
    }

    public void setResponseToJson() {
        useJsonOutput = true;
    }

    public String build() {
        String formattedPrompt = "Create a quiz with the prompt should be: " + prompt + ". ";
        if (useJsonOutput) {
            formattedPrompt += PromptLabels.SET_QUIZ_INSTRUCTIONS + PromptLabels.SET_JSON_OUTPUT;
        }
        return formattedPrompt;
    }
}
