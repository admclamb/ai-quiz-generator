package com.aiquizgenerator.core.openai.exceptions;

public class NoResponsesFoundException extends RuntimeException {
    public NoResponsesFoundException() {
        super("No responses found from openai");
    }
}
