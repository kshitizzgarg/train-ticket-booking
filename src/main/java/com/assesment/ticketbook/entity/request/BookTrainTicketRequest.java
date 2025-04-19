package com.assesment.ticketbook.entity.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookTrainTicketRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String emailAddress;

    @NotNull
    private Long trainScheduleId;

    @NotNull
    private Long transactionId;

    public BookTrainTicketRequest() {
    }

    public BookTrainTicketRequest(String firstName, String lastName, String emailAddress, Long trainScheduleId, Long transactionId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.trainScheduleId = trainScheduleId;
        this.transactionId = transactionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getTrainScheduleId() {
        return trainScheduleId;
    }

    public void setTrainScheduleId(Long trainScheduleId) {
        this.trainScheduleId = trainScheduleId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
