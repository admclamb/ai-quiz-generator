package com.aiquizgenerator.backend.generator.controllers;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.generator.testfixtures.GeneratorServiceMock;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import com.aiquizgenerator.backend.vendors.openai.testfixtures.OpenaiServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GeneratorControllerTest {
    @Test()
    public void Should_Return_Error_If_Openai_Cannot_Create_Quiz() throws  Exception {
        GeneratorService generatorServiceMock = GeneratorServiceMock.mockCreateQuiz(new Quiz(), new Quiz());
        OpenaiService openaiServiceMock = OpenaiServiceMock.mockGenerateQuiz(null, null);
        String expectedMessage = "Error getting the generated quiz.";

        GeneratorController controller = new GeneratorController(generatorServiceMock, openaiServiceMock);

        try {
            controller.generate(null);
        } catch (Exception actualException) {
            Assertions.assertEquals(expectedMessage, actualException.getMessage());
        }
    }
}
