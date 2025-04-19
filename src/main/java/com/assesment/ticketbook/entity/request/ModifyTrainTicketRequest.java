package com.assesment.ticketbook.entity.request;

import jakarta.validation.constraints.NotNull;

public class ModifyTrainTicketRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long existingTrainTicketId;
    private Long newTrainSeatId;

    public ModifyTrainTicketRequest() {
    }

    public ModifyTrainTicketRequest(Long userId, Long existingTrainTicketId, Long newTrainSeatId) {
        this.userId = userId;
        this.existingTrainTicketId = existingTrainTicketId;
        this.newTrainSeatId = newTrainSeatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getExistingTrainTicketId() {
        return existingTrainTicketId;
    }

    public void setExistingTrainTicketId(Long existingTrainTicketId) {
        this.existingTrainTicketId = existingTrainTicketId;
    }

    public Long getNewTrainSeatId() {
        return newTrainSeatId;
    }

    public void setNewTrainSeatId(Long newTrainSeatId) {
        this.newTrainSeatId = newTrainSeatId;
    }
}
