package com.assesment.ticketbook.repository;

import com.assesment.ticketbook.entity.TicketStatus;
import com.assesment.ticketbook.entity.TrainSeat;
import com.assesment.ticketbook.entity.TrainTicket;
import com.assesment.ticketbook.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class TrainTicketRepositoryTest {

    private List<TrainTicket> trainTicket;
    private List<TrainSeat> trainSeat;

    @Autowired
    TrainTicketRepository trainTicketRepository;

    @Autowired
    TrainSeatsRepository trainSeatsRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setupData(){
        trainSeat = new ArrayList<>();
        trainTicket = new ArrayList<>();
        User user = userRepository.findById(1L).get();
        TrainSeat trainSeat1 = trainSeatsRepository.findById(2L).get();
        TrainSeat trainSeat2 = trainSeatsRepository.findById(3L).get();
        TrainTicket savedTicket = trainTicketRepository.save(new TrainTicket(null, user, trainSeat1, 20d, TicketStatus.BOOKED));
        TrainTicket secondSavedTicket = trainTicketRepository.save(new TrainTicket(null, user, trainSeat2, 20d, TicketStatus.BOOKED));
        trainTicket.add(savedTicket);
        trainTicket.add(secondSavedTicket);
        trainSeat.add(trainSeat1);
        trainSeat.add(trainSeat2);
    }

    @Test
    public void testFindAllByTrainSeatInAndTicketStatus(){
        List<TrainTicket> trainTickets = trainTicketRepository.findAllByTrainSeatInAndTicketStatus(trainSeat, TicketStatus.BOOKED);
        Assertions.assertThat(trainTickets.size()).isEqualTo(2);
        Assertions.assertThat(trainTickets.containsAll(trainTicket));
    }
}
