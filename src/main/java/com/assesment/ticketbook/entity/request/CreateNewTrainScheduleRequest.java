package com.assesment.ticketbook.entity.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateNewTrainScheduleRequest {

    @NotNull
    private Long trainDetailId;

    @NotBlank
    private String departureDate;

    @NotNull
    private Double cost;

    public CreateNewTrainScheduleRequest() {
    }

    public CreateNewTrainScheduleRequest(Long trainDetailId, String departureDate, Double cost) {
        this.trainDetailId = trainDetailId;
        this.departureDate = departureDate;
        this.cost = cost;
    }

    public Long getTrainDetailId() {
        return trainDetailId;
    }

    public void setTrainDetailId(Long trainDetailId) {
        this.trainDetailId = trainDetailId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
