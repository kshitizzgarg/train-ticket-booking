package com.assesment.ticketbook.exception;

public class NoResourceFoundForGivenRequestException extends RuntimeException{
    public NoResourceFoundForGivenRequestException(String message){
        super(message);
    }
}
