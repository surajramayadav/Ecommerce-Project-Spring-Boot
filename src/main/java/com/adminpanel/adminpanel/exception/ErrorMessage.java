package com.adminpanel.adminpanel.exception;

import java.util.Date;

public class ErrorMessage {

    private String message;
    private String detail;
    private boolean status;
    private Date timestamp;

    public ErrorMessage(){}

   public ErrorMessage(String message, String detail, boolean status, Date timestamp) {
        this.status=status;
        this.message = message;
        this.detail = detail;
        this.timestamp = timestamp;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
