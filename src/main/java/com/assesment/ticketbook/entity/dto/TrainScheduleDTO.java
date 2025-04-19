package com.assesment.ticketbook.entity.dto;

import java.util.Date;

public class TrainScheduleDTO {
    private Long id;
    private TrainDetailDTO trainDetailDTO;
    private Date departureDate;
    private Double cost;

    public TrainScheduleDTO() {
    }

    public TrainScheduleDTO(Long id, TrainDetailDTO trainDetailDTO, Date departureDate, Double cost) {
        this.id = id;
        this.trainDetailDTO = trainDetailDTO;
        this.departureDate = departureDate;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainDetailDTO getTrainDetailDTO() {
        return trainDetailDTO;
    }

    public void setTrainDetailDTO(TrainDetailDTO trainDetail) {
        this.trainDetailDTO = trainDetail;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
