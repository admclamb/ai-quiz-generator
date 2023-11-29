package com.aiquizgenerator.backend.vendors.openai.labels;

public class PromptLabels {
    public static final String SET_JSON_OUTPUT = """
            Return the output in json format. The response should have a json property of category which is an array of the Strings of categories of the quiz. The json should have another property of questions
             which will be an array of questions. The questions should have the properties of question, answers, and correctAnswer. The answer will be the text of the answer. Make sure the text matches the correct value. Do not include any explanations, only provide a RFC8259 compliant JSON response following the next format without deviation. Here is an example of the json format:
            {
              "categories": [
                {
                  "name": "History"
                },
                {
                  "name": "Military"
                },
                {
                  "name": "WW2"
                }
              ],
              "questions": [
                {
                  "question": "When was WW2?",
                  "answers": [
                    {
                      "answer": "September 1, 1939"
                    },
                    {
                      "answer": "January 2, 2001"
                    },
                    {
                      "answer": "May 4, 1998"
                    },
                    {
                      "answer": "October 4, 1900"
                    }
                  ],
                  "correctAnswer": "September 1, 1939"
                }
              ]
            }
            """;

    public static final String SET_QUIZ_INSTRUCTIONS = "Create a multiple choice quiz. The minimum answers can be 2, and the maximum can be 4.";

    public static final String MAX_PROMPT_SIZE = "A prompt must be at most 100 characters";

    public static final String PROMPT_NOT_EMPTY = "A prompt cannot be empty";
}