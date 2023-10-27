package com.aiquizgenerator.backend.generator.controllers;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/generator")
public class GeneratorController {

    private final GeneratorService generatorService;

    private final OpenaiService openaiService;

    @GetMapping()
    public String test() {
        System.out.println("TEST");
        return "This is a test";
    }


    @PostMapping("/generate")
    public Quiz generate(@RequestBody @Validated PromptDTO prompt) {
        System.out.println("HERE");
        System.out.println((prompt));
        Quiz generatedQuiz = openaiService.generate(prompt);
        return generatorService.createQuiz(generatedQuiz);
    }

}