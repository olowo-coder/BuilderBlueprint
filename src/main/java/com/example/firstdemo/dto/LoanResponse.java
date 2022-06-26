package com.example.firstdemo.dto;

import com.example.firstdemo.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoanResponse {
    private String accountNumber;
    private double amount;

    private String transDate = Utils.getCurrentDate();

    public LoanResponse() {
    }

    public LoanResponse(String stringData) {
        this.accountNumber = new Gson().fromJson(stringData, LoanResponse.class).getAccountNumber();
        this.amount = new Gson().fromJson(stringData, LoanResponse.class).getAmount();
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
