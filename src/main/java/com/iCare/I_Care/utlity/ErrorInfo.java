package com.iCare.I_Care.utlity;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorInfo {

    private String errorMessage;
    private Long errorCode;
    private LocalDateTime timeStamp;

    public ErrorInfo(String errorMessage, Long errorCode, LocalDateTime timeStamp) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.timeStamp = timeStamp;
    }

    public ErrorInfo() {
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
