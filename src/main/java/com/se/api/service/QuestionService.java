package com.se.api.service;

import com.se.api.mapper.MapStructMapper;
import com.se.api.utility.Utility;
import com.ul.model.QAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("question")
public class QuestionService implements Questionnaire {

    @Autowired
    private MapStructMapper mapStructMapper;
    private QAResponse qaResponse;

    @Override
    public QAResponse response() {
        qaResponse = new QAResponse();
        qaResponse = mapStructMapper.mapQAResponse(mapStructMapper.mapQAResponse(qaResponse.items(Utility.mapRandomNoList())));
        return mapStructMapper.mapQAResponse(qaResponse.code(Utility.Base64Encoding(qaResponse.toString())));
    }

    @Override
    public QAResponse response(QAResponse qaResponse) {
        return null;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }

}
