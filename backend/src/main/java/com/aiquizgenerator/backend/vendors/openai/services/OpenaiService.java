package com.aiquizgenerator.backend.vendors.openai.services;

import com.aiquizgenerator.backend.data.entities.Answer;
import com.aiquizgenerator.backend.data.entities.Category;
import com.aiquizgenerator.backend.data.entities.Question;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class OpenaiService {

    @Autowired
    private OpenaiCrudService openaiCrudService;

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
            System.out.println("RESPONSE => " + response);
            Quiz mappedQuiz = objectMapper.readValue(response, Quiz.class);
            saveCategories(mappedQuiz.getCategories());
            for (Question question: mappedQuiz.getQuestions()) {
                System.out.println(question.getQuestion());
                System.out.println("=================================");
                for (Answer answer: question.getAnswers()) {
                    System.out.println(answer.getAnswer());
                }
            }
            mappedQuiz.setPrompt(prompt.getPrompt());
            return mappedQuiz;
        } catch (JsonProcessingException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    private void saveCategories(List<Category> categories) {
        for(Category category: categories) {
                Category savedOrFoundCategory = openaiCrudService.findOrSaveCategory(category);
                category.setId(savedOrFoundCategory.getId());
        }
    }
}
