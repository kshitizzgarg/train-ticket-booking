package com.assesment.ticketbook.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TrainDetails")
public class TrainDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "train_details_SEQ")
    @SequenceGenerator(name = "train_details_SEQ", sequenceName = "train_details_SEQ",  allocationSize=1)
    private Long id;
    private String trainName;
    @Enumerated(EnumType.STRING)
    private StationName stationFrom;
    @Enumerated(EnumType.STRING)
    private StationName stationTo;

    public TrainDetail() {
    }

    public TrainDetail(Long id, String trainName, StationName stationFrom, StationName stationTo) {
        this.id = id;
        this.trainName = trainName;
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public StationName getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(StationName stationFrom) {
        this.stationFrom = stationFrom;
    }

    public StationName getStationTo() {
        return stationTo;
    }

    public void setStationTo(StationName stationTo) {
        this.stationTo = stationTo;
    }
}
