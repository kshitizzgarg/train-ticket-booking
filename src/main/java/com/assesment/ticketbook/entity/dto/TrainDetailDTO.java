package com.assesment.ticketbook.entity.dto;

import com.assesment.ticketbook.entity.StationName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TrainDetailDTO {
    private long id;
    private String trainName;
    private String stationFrom;
    private String stationTo;

    public TrainDetailDTO() {
    }

    public TrainDetailDTO(long id, String trainName, String stationFrom, String stationTo) {
        this.id = id;
        this.trainName = trainName;
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(String stationFrom) {
        this.stationFrom = stationFrom;
    }

    public String getStationTo() {
        return stationTo;
    }

    public void setStationTo(String stationTo) {
        this.stationTo = stationTo;
    }
}
