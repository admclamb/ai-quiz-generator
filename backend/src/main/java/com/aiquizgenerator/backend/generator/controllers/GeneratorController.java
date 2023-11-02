package com.aiquizgenerator.backend.generator.controllers;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.generator.exceptions.NoQuizFoundException;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/generator")
@CrossOrigin(origins = "http://localhost:4040")
public class GeneratorController {

    private final GeneratorService generatorService;

    private final OpenaiService openaiService;

    @GetMapping()
    public String test() {
        return "This is a test";
    }

    @PostMapping("/generate")
    public Quiz generate(@RequestBody @Valid PromptDTO prompt) {
        Quiz generatedQuiz = openaiService.generateQuiz(prompt);
        if (generatedQuiz == null) {
            throw new NoQuizFoundException();
        }
        return generatorService.createQuiz(generatedQuiz);
    }
}