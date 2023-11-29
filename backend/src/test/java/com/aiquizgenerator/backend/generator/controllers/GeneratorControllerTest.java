package com.aiquizgenerator.backend.generator.controllers;

import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.generator.testfixtures.GeneratorServiceMock;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import com.aiquizgenerator.backend.vendors.openai.testfixtures.OpenaiServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
