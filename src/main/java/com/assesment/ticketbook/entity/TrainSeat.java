package com.assesment.ticketbook.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TrainSeats")
public class TrainSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Train_Seats_seq")
    @SequenceGenerator(name = "Train_Seats_seq", sequenceName = "Train_Seats_seq",  allocationSize=1)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="train_schedule_id", referencedColumnName = "id")
    private TrainSchedule trainSchedule;

    @Enumerated(EnumType.STRING)
    private SectionName sectionName;

    private Integer seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatBookingStatus seatBookingStatus;

    public TrainSeat() {
    }

    public TrainSeat(long id, TrainSchedule trainSchedule, SectionName sectionName, Integer seatNumber, SeatBookingStatus seatBookingStatus) {
        this.id = id;
        this.trainSchedule = trainSchedule;
        this.sectionName = sectionName;
        this.seatNumber = seatNumber;
        this.seatBookingStatus = seatBookingStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TrainSchedule getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(TrainSchedule trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    public SectionName getSectionName() {
        return sectionName;
    }

    public void setSectionName(SectionName sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatBookingStatus getSeatBookingStatus() {
        return seatBookingStatus;
    }

    public void setSeatBookingStatus(SeatBookingStatus seatBookingStatus) {
        this.seatBookingStatus = seatBookingStatus;
    }
}
