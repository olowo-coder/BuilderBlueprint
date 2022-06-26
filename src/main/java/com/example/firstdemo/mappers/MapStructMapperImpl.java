package com.example.firstdemo.mappers;

import com.example.firstdemo.dto.LoanRequest;
import com.example.firstdemo.dto.LoanResponse;

public class MapStructMapperImpl implements MapStructMapper{

    @Override
    public LoanResponse loanRequestToLoanResponse(LoanRequest request) {
        if(request == null) return null;
        LoanResponse loanResponse = new LoanResponse();
         loanResponse.setAccountNumber(request.getAccountNumber());
         loanResponse.setAmount(request.getAmount().doubleValue());
        return loanResponse;
    }
}
