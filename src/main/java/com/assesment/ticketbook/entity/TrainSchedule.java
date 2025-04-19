package com.assesment.ticketbook.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="TrainSchedule")
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Train_schedule_seq")
    @SequenceGenerator(name = "Train_schedule_seq", sequenceName = "Train_schedule_seq",  allocationSize=1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="train_details_id", referencedColumnName = "id")
    private TrainDetail trainDetail;

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    private Double cost;

    public TrainSchedule() {
    }

    public TrainSchedule(Long id, TrainDetail trainDetail, Date departureDate, Double cost) {
        this.id = id;
        this.trainDetail = trainDetail;
        this.departureDate = departureDate;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainDetail getTrainDetail() {
        return trainDetail;
    }

    public void setTrainDetail(TrainDetail trainDetail) {
        this.trainDetail = trainDetail;
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
