package com.se.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.api.mapper.MapStructMapper;
import com.se.api.utility.Utility;
import com.ul.model.QAResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    @InjectMocks
    private QuestionService questionServiceMock;
    @Mock
    private QAResponse qaResponseMock;
    @Mock
    private MapStructMapper mapStructMapperMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        qaResponseMock = new QAResponse();
        qaResponseMock.setCode(Utility.Base64Encoding("Test_Code"));
        qaResponseMock.setQuestion("Test_Question");
        qaResponseMock.items(Utility.mapRandomNoList());
    }

    @Test
    public void WhenSuccessResponse() throws JsonProcessingException {
        when(mapStructMapperMock.mapQAResponse(any(QAResponse.class))).thenReturn(qaResponseMock);
        Assert.assertNotNull(questionServiceMock.response());

        Assert.assertNotEquals(Utility.Base64Encoding(qaResponseMock.toString()),qaResponseMock.getCode());
    }
}