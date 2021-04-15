package com.se.api.service;

import com.ul.model.QAResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface Questionnaire {
    QAResponse response();

    QAResponse response(QAResponse qaResponse);

    HttpStatus getHttpStatus();
}
