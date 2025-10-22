package com.iCare.I_Care.exception;

import com.iCare.I_Care.utlity.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler() {
        ErrorInfo errorInfo = new ErrorInfo("Something Went Wrong", (long) HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<ErrorInfo> exceptionHandlerForNotificationException() {
        ErrorInfo errorInfo = new ErrorInfo("Error While Sending Notification - Some Validations Missing", (long) HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
