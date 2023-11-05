package com.aiquizgenerator.backend.generator.exceptions;

import com.aiquizgenerator.backend.generator.labels.GeneratorLabels;

public class NoQuizFoundException extends RuntimeException {
    public NoQuizFoundException() {super(GeneratorLabels.NO_QUIZ_FOUND);}
}
