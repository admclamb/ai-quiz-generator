package com.aiquizgenerator.backend.vendors.openai.labels;

public class PromptLabels {
    public static final String SET_JSON_OUTPUT = "Return the output in json format. The response should have a json property of category which is an array of the categories of where the quiz would be. The questions should have the properties of question, answers, and correctAnswer. The answer will be the text of the answer. Make sure the text matches the correct value. An example of the output for a quiz would be: {\n" +
            "  \"category\": [\"Politics\", \"History\"],\n" +
            "  \"questions\": [\n" +
            "    {\n" +
            "      \"question\": \"In which country was Osama bin Laden killed?\",\n" +
            "      \"answers\": [\n" +
            "        {\"answer\": \"Iraq\"},\n" +
            "        {\"answer\": \"Pakistan\"},\n" +
            "        {\"answer\": \"Afghanistan\"},\n" +
            "        {\"answer\": \"Saudi Arabia\"}\n" +
            "      ],\n" +
            "      \"correctAnswer\": \"Pakistan\"" +
            "    },\n" +
            "}";

    public static final String SET_QUIZ_INSTRUCTIONS = "Create a multiple choice quiz. The minimum answers can be 2, and the maximum can be 4.";

    public static final String MAX_PROMPT_SIZE = "A prompt must be at most 100 characters";

    public static final String PROMPT_NOT_EMPTY = "A prompt cannot be empty";
}