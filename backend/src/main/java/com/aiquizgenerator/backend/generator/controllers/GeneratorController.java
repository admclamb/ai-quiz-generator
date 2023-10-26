package com.aiquizgenerator.backend.generator.controllers;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/generator")
public class GeneratorController {

    private final GeneratorService generatorService;

    private final OpenaiService openaiService;


    @PostMapping("/generate")
    public Quiz generate(@RequestBody @Validated PromptDTO prompt) {
        Quiz generatedQuiz = openaiService.generate(prompt);
        return generatorService.createQuiz(generatedQuiz);
    }

}