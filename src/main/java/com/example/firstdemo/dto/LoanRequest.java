package com.example.firstdemo.dto;

import com.google.gson.GsonBuilder;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LoanRequest {

    public LoanRequest() {
    }


    @Pattern(regexp = "[0-9]+", message = "Must all be numbers")
    @Size(min = 10, max = 10, message = "{account.error.test}")
    private String accountNumber;

    @Digits(integer = 40, fraction = 2, message = "{decimal.error.test}")
//    @Digits(integer = 3, fraction = 2, message = "must be two decimal")
//    @Pattern(regexp = "^[0-9]*\\.[0-9]{2}$")
    private BigDecimal amount;

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

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
