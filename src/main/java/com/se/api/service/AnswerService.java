package com.se.api.service;

import com.se.api.mapper.MapStructMapper;
import com.se.api.utility.Utility;
import com.ul.model.QAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("answer")
public class AnswerService implements Questionnaire {
    private HttpStatus httpStatus;

    @Autowired
    private MapStructMapper mapStructMapper;

    @Override
    public QAResponse response() {
        return null;
    }

    @Override
    public QAResponse response(QAResponse qaResponse) {
        if (codeValidate(qaResponse)) {
            qaResponse = add(qaResponse);
            httpStatus = HttpStatus.OK;
        } else {
            qaResponse.question(qaResponse.getQuestion().concat("Manipulated!"));
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return qaResponse;
    }

    private Boolean codeValidate(QAResponse qaResponse) {
        return qaResponse.getCode().equals(Utility.Base64Encoding(mapStructMapper.mapQARequest(qaResponse).toString()));
    }

    private QAResponse add(QAResponse qaResponse) {
        Long result = 0L;
        for (Long item : qaResponse.getItems())
            result += item;
        if (result.equals(qaResponse.getAnswer()))
            qaResponse.question(qaResponse.getQuestion().concat("That’s great!"));
        else qaResponse.question(qaResponse.getQuestion().concat("That’s wrong. Please try again."));
        mapStructMapper.mapQAResponse(qaResponse);
        return qaResponse;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
