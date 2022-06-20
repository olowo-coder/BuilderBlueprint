package com.example.firstdemo.dto;

import com.example.firstdemo.validatior.IdValidate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.GsonBuilder;
import jdk.jfr.BooleanFlag;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LoanRequest {

    public LoanRequest() {
    }


    @Positive
    @NotNull
    private Long loanId;
//    @IdValidate
    private Long requestId;

    @Pattern(regexp = "\\d{10}", message = "Must all be numbers")
    @NotNull
    private String accountNumber;

    @Digits(integer = 40, fraction = 2, message = "{decimal.error.test}")
    @Positive(message = "amount must be positive")
    @NotNull(message = "cannot be null")
    private BigDecimal amount;

//    @NotNull(message = "Either true or false")
//    @AssertTrue(message="choose true or false")
//    @JsonProperty
    private boolean isCredit;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(boolean credit) {
        isCredit = credit;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
