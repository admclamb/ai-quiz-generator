package com.aiquizgenerator.backend.generator.controllers;

import com.aiquizgenerator.backend.data.entities.Question;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.generator.exceptions.NoQuizFoundException;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/generator")
@CrossOrigin(origins = "http://localhost:4040")
public class GeneratorController {
    private final GeneratorService generatorService;
    private final OpenaiService openaiService;

    @PostMapping("/generate")
    public Quiz generate(@RequestBody @Valid PromptDTO prompt) {
        Quiz generatedQuiz = openaiService.generateQuiz(prompt);
        if (generatedQuiz == null) {
            throw new NoQuizFoundException();
        }
        System.out.println(generatedQuiz);
        System.out.println(generatedQuiz.getPrompt());
        if (generatedQuiz.getQuestions() != null) {
            for (Question question: generatedQuiz.getQuestions()) {
                System.out.println(question.getQuestion());
            }
        }

        generatedQuiz.setCreatedAt(LocalDateTime.now());
        generatedQuiz.setUpdatedAt(LocalDateTime.now());
        return generatorService.createQuiz(generatedQuiz);
    }
}