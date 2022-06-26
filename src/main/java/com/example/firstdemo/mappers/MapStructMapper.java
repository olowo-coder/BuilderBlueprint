package com.example.firstdemo.mappers;

import com.example.firstdemo.dto.LoanRequest;
import com.example.firstdemo.dto.LoanResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface MapStructMapper {
    MapStructMapper MAPPER = Mappers.getMapper(MapStructMapper.class);

    LoanResponse loanRequestToLoanResponse(LoanRequest request);
}
