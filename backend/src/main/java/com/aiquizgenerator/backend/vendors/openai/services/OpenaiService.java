package com.aiquizgenerator.backend.vendors.openai.services;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.vendors.openai.dtos.ChatRequest;
import com.aiquizgenerator.backend.vendors.openai.dtos.ChatResponse;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenaiService {
    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value(("${openai.model}"))
    private String model;

    @Value(("${openai.api.url}"))
    private String apiUrl;

    private final ObjectMapper objectMapper;

    @Autowired
    public OpenaiService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String chat(String prompt) {
        ChatRequest request = new ChatRequest(model, prompt);

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }

    public Quiz generateQuiz(PromptDTO prompt) {
        prompt.setResponseToJson();
        try {
            String response = chat(prompt.build());
            Quiz mappedQuiz = objectMapper.readValue(response, Quiz.class);
            mappedQuiz.setPrompt(prompt.getPrompt());
            return mappedQuiz;
        } catch (JsonProcessingException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

}
