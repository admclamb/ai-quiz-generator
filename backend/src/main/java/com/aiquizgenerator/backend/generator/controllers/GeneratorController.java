package com.aiquizgenerator.backend.generator.controllers;

import com.aiquizgenerator.backend.data.entities.Category;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.data.entities.QuizQuestionAnswer;
import com.aiquizgenerator.backend.generator.exceptions.NoQuizFoundException;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/generator")
public class GeneratorController {

    private final GeneratorService generatorService;

    private final OpenaiService openaiService;

    @GetMapping()
    public String test() {
        return "This is a test";
    }

    @PostMapping("/generate")
    public Quiz generate(@RequestBody @Validated PromptDTO prompt) {
        Quiz generatedQuiz = openaiService.generateQuiz(prompt);
        if (generatedQuiz == null) {
            throw new NoQuizFoundException();
        }
        return generatorService.createQuiz(generatedQuiz);
    }

    private List<Category> createCategories(Set<Category> categories) {
        Iterable<Category> iterableCategories = generatorService.createCategories(categories);
        List<Category> listCategories = new ArrayList<>();
        iterableCategories.forEach(listCategories::add);
        return listCategories;
    }

    private List<QuizQuestionAnswer> createQuestionAnswers(Set<QuizQuestionAnswer> answers) {
        Iterable<QuizQuestionAnswer> iterableAnswers = generatorService.createQuizQuestionAnswers(answers);
        List<QuizQuestionAnswer> listAnswers = new ArrayList<>();
        iterableAnswers.forEach(listAnswers::add);
        return listAnswers;
    }
}