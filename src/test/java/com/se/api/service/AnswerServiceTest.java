package com.se.api.service;

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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnswerServiceTest {
    @InjectMocks
    private AnswerService answerServiceMock;
    @Mock
    private QAResponse qaResponseMock;
    @Mock
    private MapStructMapper mapStructMapperMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        List<Long> list  = new ArrayList<>();
        list.add(2L);
        list.add(5L);
        qaResponseMock = new QAResponse();
        qaResponseMock.setCode("Test_Code");
        qaResponseMock.items(list);
        qaResponseMock.setQuestion("Test_Question");
        qaResponseMock.setAnswer(7L);
        when(mapStructMapperMock.mapQARequest(qaResponseMock)).thenReturn(qaResponseMock);
    }

    @Test
    public void SuccessResponse() {
        Assert.assertNotNull(answerServiceMock.response(qaResponseMock));
        Assert.assertEquals(qaResponseMock,answerServiceMock.response(qaResponseMock));
    }

    @Test
    public void FailureResponse() {
        Assert.assertNotEquals(Utility.Base64Encoding(qaResponseMock.toString()),Utility.Base64Encoding(answerServiceMock.response(qaResponseMock.code("Test_Code_Modified")).toString()));
    }
}