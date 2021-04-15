package com.se.api.controller;

import com.se.api.service.Questionnaire;
import com.ul.api.QuestionAnswerApi;
import com.ul.model.QAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Controller implements QuestionAnswerApi {

    @Autowired
    @Qualifier("question")
    private Questionnaire question;
    @Autowired
    @Qualifier("answer")
    private Questionnaire answer;

    @Override
    public ResponseEntity<QAResponse> getRandomQuestions() {
        return new ResponseEntity<>(question.response(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<QAResponse> postAnswer(@Valid QAResponse qaResponse) {
        return new ResponseEntity<>(answer.response(qaResponse), answer.getHttpStatus());
    }
}