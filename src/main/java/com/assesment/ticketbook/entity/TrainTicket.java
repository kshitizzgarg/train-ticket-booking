package com.assesment.ticketbook.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Train_ticket")
public class TrainTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Train_ticket_seq")
    @SequenceGenerator(name = "Train_ticket_seq", sequenceName = "Train_ticket_seq",  allocationSize=1)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name="train_seat_id", referencedColumnName = "id")
    private TrainSeat trainSeat;

    private Double price;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    public TrainTicket() {
    }

    public TrainTicket(Long id, User user, TrainSeat trainSeat, Double price, TicketStatus ticketStatus) {
        this.id = id;
        this.user = user;
        this.trainSeat = trainSeat;
        this.price = price;
        this.ticketStatus = ticketStatus;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TrainSeat getTrainSeat() {
        return trainSeat;
    }

    public void setTrainSeat(TrainSeat trainSeat) {
        this.trainSeat = trainSeat;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
