package com.willdom.test.exception;

import com.willdom.test.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionController {
    @Autowired
    ILogService logService;
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(
            Exception ex, WebRequest request) {
        String message = "An error ocurred in the serivce, please check";
        return new ResponseEntity<>(getBody(message,ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleRuntimeException(
            NumberFormatException ex, WebRequest request) {
        String message = "There's  an error with the number provided";
        return new ResponseEntity<>(getBody(message,ex), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleRuntimeException(
            MissingServletRequestParameterException ex, WebRequest request) {
        String message = "There's  an error with the number provided";
        return new ResponseEntity<>(getBody(message,ex), HttpStatus.BAD_REQUEST);
    }
    private Map<String, Object> getBody(String message,Throwable exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        logService.doLogEntry(exception);
        return body;
    }
}
