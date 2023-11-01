package com.aiquizgenerator.backend.vendors.openai.labels;

public class PromptLabels {
    public static final String SET_JSON_OUTPUT = "Return the output in json format. The response should have a json property of category which is an array of the categories of where the quiz would be. The questions should have the properties of question, answers, and correct answer. The answer will be an object with property of answer being the answer";

    public static final String SET_QUIZ_INSTRUCTIONS = "Create a multiple choice quiz. The minimum answers can be 2, and the maximum can be 4.";
}