package com.assesment.ticketbook.entity.request;

import jakarta.validation.constraints.NotNull;

public class CancelTrainTicketRequest {
    @NotNull
    private Long trainTicketId;
    @NotNull
    private Long userId;

    public CancelTrainTicketRequest() {
    }

    public CancelTrainTicketRequest(Long trainTicketId, Long userId) {
        this.trainTicketId = trainTicketId;
        this.userId = userId;
    }

    public Long getTrainTicketId() {
        return trainTicketId;
    }

    public void setTrainTicketId(Long trainTicketId) {
        this.trainTicketId = trainTicketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
