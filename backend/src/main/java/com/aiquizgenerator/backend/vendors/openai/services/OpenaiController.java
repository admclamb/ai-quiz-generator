package com.aiquizgenerator.backend.vendors.openai.services;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OpenaiController {

    private final OpenaiService openaiService;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        return openaiService.chat(prompt);
    }
}
