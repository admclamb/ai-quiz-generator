package com.aiquizgenerator.core.openai.services;

import com.aiquizgenerator.core.openai.dtos.ChatRequest;
import com.aiquizgenerator.core.openai.dtos.ChatResponse;
import com.aiquizgenerator.core.openai.exceptions.NoResponsesFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class OpenaiService {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value(("${openai.model"))
    private String model;

    @Value(("${openai.api.url}"))
    private String apiUrl;

    public ChatResponse chat(String prompt) {
        ChatRequest request = new ChatRequest(model, prompt);

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            throw new NoResponsesFoundException();
        }

        return response;
    }
}
