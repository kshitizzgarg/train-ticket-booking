package com.assesment.ticketbook.entity.request;

import jakarta.validation.constraints.NotBlank;

public class CreateNewTrainDetailRequest {

    @NotBlank
    private String trainName;

    @NotBlank
    private String stationNameFrom;

    @NotBlank
    private String stationNameTo;


    public CreateNewTrainDetailRequest() {
    }

    public CreateNewTrainDetailRequest(String trainName, String stationNameFrom, String stationNameTo) {
        this.trainName = trainName;
        this.stationNameFrom = stationNameFrom;
        this.stationNameTo = stationNameTo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStationNameFrom() {
        return stationNameFrom;
    }

    public void setStationNameFrom(String stationNameFrom) {
        this.stationNameFrom = stationNameFrom;
    }

    public String getStationNameTo() {
        return stationNameTo;
    }

    public void setStationNameTo(String stationNameTo) {
        this.stationNameTo = stationNameTo;
    }
}
