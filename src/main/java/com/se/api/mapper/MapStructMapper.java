package com.se.api.mapper;

import com.ul.model.QAResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    @Mappings({
            @Mapping(target = "code", ignore = true),
            @Mapping(source = "question", target = "question"),
            @Mapping(source = "items", target = "items"),
            @Mapping(target = "answer", ignore = true)
    })
    QAResponse mapQARequest(QAResponse qaResponse);

    @Mappings({
            @Mapping(source = "code", target = "code"),
            @Mapping(target = "question", constant = "Please sum the numbers : "),
            @Mapping(source = "items", target = "items")
    })
    QAResponse mapQAResponse(QAResponse qaResponse);
}