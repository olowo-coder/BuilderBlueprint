package com.example.firstdemo.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class RequestEnquiryDto {

    private Long requestId;

    private String responseMessage;

    private Map requestObject;

    private Date timestamp;

    public RequestEnquiryDto(Long requestId, String responseMessage, Map requestObject, Date timestamp) {
        this.requestId = requestId;
        this.responseMessage = responseMessage;
        this.requestObject = requestObject;
        this.timestamp = timestamp;
    }


    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Map getRequestObject() {
        return requestObject;
    }

    public void setRequestObject(Map requestObject) {
        this.requestObject = requestObject;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
