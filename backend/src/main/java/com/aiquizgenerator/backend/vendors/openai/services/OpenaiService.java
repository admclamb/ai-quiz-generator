package com.aiquizgenerator.backend.vendors.openai.services;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.vendors.openai.dtos.ChatRequestDTO;
import com.aiquizgenerator.backend.vendors.openai.dtos.ChatResponseDTO;
import com.aiquizgenerator.backend.vendors.openai.exceptions.NoResponseFoundException;
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

    @Value(("${openai.api.url"))
    private String apiUrl;

    private final ObjectMapper objectMapper;

    @Autowired
    public OpenaiService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Quiz generate(PromptDTO prompt) {
        prompt.setResponseToJson();
        ChatRequestDTO request = new ChatRequestDTO(model, prompt.build());



        ChatResponseDTO response = restTemplate.postForObject(apiUrl, request, ChatResponseDTO.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            throw new NoResponseFoundException();
        }

        try {
            String jsonResponse = response.getChoices().get(0).getMessage().getContent();
            return objectMapper.readValue(jsonResponse, Quiz.class);
        } catch(JsonProcessingException error) {
            return null;
        }
    }
}
