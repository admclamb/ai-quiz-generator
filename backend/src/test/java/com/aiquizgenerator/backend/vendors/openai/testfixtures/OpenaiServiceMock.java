package com.aiquizgenerator.backend.vendors.openai.testfixtures;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.vendors.openai.dtos.PromptDTO;
import com.aiquizgenerator.backend.vendors.openai.services.OpenaiService;
import org.mockito.Mockito;

public class OpenaiServiceMock {

    public static OpenaiService mockGenerateQuiz(PromptDTO mockParam, Quiz returnValue) throws Exception {
        OpenaiService mockedOpenaiService = Mockito.mock(OpenaiService.class);
        Mockito.when(mockedOpenaiService.generateQuiz(mockParam)).thenReturn(returnValue);
        return mockedOpenaiService;
    }
}
