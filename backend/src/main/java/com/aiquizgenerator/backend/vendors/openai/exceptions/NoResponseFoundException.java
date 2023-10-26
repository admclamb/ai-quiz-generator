package com.aiquizgenerator.backend.vendors.openai.exceptions;

import com.aiquizgenerator.backend.vendors.openai.labels.OpenaiLabels;

public class NoResponseFoundException extends RuntimeException {
    public NoResponseFoundException() {
        super(OpenaiLabels.NO_RESPONSE_FOUND);
    }
}