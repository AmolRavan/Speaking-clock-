package com.example.speakingclock.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class SpeakingClockControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(SpeakingClockControllerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<String> handleGenericException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = DateTimeParseException.class)
    public final ResponseEntity<String> handleDateTimeParseException(DateTimeParseException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
