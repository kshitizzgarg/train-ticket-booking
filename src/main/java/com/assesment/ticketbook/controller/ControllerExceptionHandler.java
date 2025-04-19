package com.assesment.ticketbook.controller;

import com.assesment.ticketbook.exception.InvalidRequestParametersException;
import com.assesment.ticketbook.exception.NoResourceFoundForGivenRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(InvalidRequestParametersException.class)
    public ResponseEntity handleInvalidRequestParametersException(InvalidRequestParametersException ex){
        log.error("An error occurred", ex);
        return new ResponseEntity("An unexpected error occurred "+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundForGivenRequestException.class)
    public ResponseEntity handleNoResourceFoundForGivenRequestException(InvalidRequestParametersException ex){
        log.error("An error occurred", ex);
        return new ResponseEntity("An unexpected error occurred "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Return a custom error message with HTTP 500 status
        log.error("An error eccurrred", ex);
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
