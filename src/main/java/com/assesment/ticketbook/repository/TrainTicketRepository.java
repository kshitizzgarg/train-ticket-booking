package com.assesment.ticketbook.repository;

import com.assesment.ticketbook.entity.TicketStatus;
import com.assesment.ticketbook.entity.TrainSeat;
import com.assesment.ticketbook.entity.TrainTicket;
import com.assesment.ticketbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainTicketRepository extends JpaRepository<TrainTicket, Long> {

    List<TrainTicket> findAllByTrainSeatInAndTicketStatus(List<TrainSeat> trainSeats, TicketStatus ticketStatus);

    List<TrainTicket> findAllByUser(User user);
}
