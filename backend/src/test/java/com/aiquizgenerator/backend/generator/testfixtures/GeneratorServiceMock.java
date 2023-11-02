package com.aiquizgenerator.backend.generator.testfixtures;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GeneratorServiceMock {

    public static GeneratorService mockCreateQuiz(Quiz mockParam, Quiz returnValue) {
        GeneratorService mockedGeneratorService = Mockito.mock(GeneratorService.class);
        Mockito.when(mockedGeneratorService.createQuiz(mockParam)).thenReturn(returnValue);
        return mockedGeneratorService;
    }
}
