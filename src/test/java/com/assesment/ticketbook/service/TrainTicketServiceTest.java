package com.assesment.ticketbook.service;

import com.assesment.ticketbook.entity.*;
import com.assesment.ticketbook.entity.dto.TrainTicketDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.entity.request.BookTrainTicketRequest;
import com.assesment.ticketbook.entity.request.CancelTrainTicketRequest;
import com.assesment.ticketbook.entity.request.ModifyTrainTicketRequest;
import com.assesment.ticketbook.exception.InvalidRequestParametersException;
import com.assesment.ticketbook.repository.TrainScheduleRepository;
import com.assesment.ticketbook.repository.TrainSeatsRepository;
import com.assesment.ticketbook.repository.TrainTicketRepository;
import com.assesment.ticketbook.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TrainTicketServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    TrainTicketRepository trainTicketRepository;

    @Mock
    TrainScheduleRepository trainScheduleRepository;

    @Mock
    TrainSeatsRepository trainSeatsRepository;

    @InjectMocks
    TrainTicketService trainTicketService;

    private User user;
    private TrainSchedule trainSchedule;
    private TrainSeat trainSeat;
    private TrainSeat modifiedTrainSeat;
    private TrainTicket trainTicket;
    private TrainTicket modifiedTrainTicket;
    private List<TrainSeat> trainSeats;
    private List<TrainTicket> trainTicketList;

    @BeforeEach
    void setup() {
        user = new User(1L, "Test", "User", "testUser@test.com");

        trainSchedule = new TrainSchedule(2l, null, null, 20d);
        trainSeat = new TrainSeat(5l, trainSchedule, SectionName.A, 4, SeatBookingStatus.VACANT);
        trainTicket = new TrainTicket(22l, user, trainSeat, 20d, TicketStatus.BOOKED);
        modifiedTrainSeat = new TrainSeat(7l, trainSchedule, SectionName.A, 4, SeatBookingStatus.VACANT);
        modifiedTrainTicket = new TrainTicket(35l, user, modifiedTrainSeat, 20d, TicketStatus.BOOKED);
        trainSeats = new ArrayList<>();
        trainTicketList=new ArrayList<>();
        trainSeats.add(trainSeat);
        trainSeats.add(modifiedTrainSeat);
        trainTicketList.add(trainTicket);
        trainTicketList.add(modifiedTrainTicket);

    }

    @Test
    public void testBookNewTrainTicket() {

        given(userRepository.getUserByFirstNameAndLastNameAndEmailAddress(user.getFirstName(), user.getLastName(), user.getEmailAddress())).willReturn(user);
        given(trainScheduleRepository.findById(2l)).willReturn(Optional.of(trainSchedule));
        given(trainSeatsRepository.findFirstBySeatBookingStatusAndTrainSchedule(SeatBookingStatus.VACANT, trainSchedule)).willReturn(Optional.of(trainSeat));
        given(trainTicketRepository.save(any())).willReturn(trainTicket);
        given(trainSeatsRepository.save(any())).willReturn(trainSeat);

        TrainTicketDTO savedTicket = trainTicketService.bookNewTrainTicket(new BookTrainTicketRequest(user.getFirstName(), user.getLastName(), user.getEmailAddress(), trainSchedule.getId(), 1234L));

        Assertions.assertThat(savedTicket.getId()).isEqualTo(trainTicket.getId());
        Assertions.assertThat(savedTicket.getUserDto().getId()).isEqualTo(user.getId());
        Assertions.assertThat(savedTicket.getTrainSeatDto().getSeatBookingStatus()).isEqualTo(SeatBookingStatus.RESERVED.toString());
    }

    @Test
    public void testCancelTrainTicket(){
        trainSeat.setSeatBookingStatus(SeatBookingStatus.RESERVED);
        given(trainTicketRepository.findById(22l)).willReturn(Optional.of(trainTicket));
        given(trainTicketRepository.save(any())).willReturn(trainTicket);

        TrainTicketDTO trainTicketDTO = trainTicketService.cancelTrainTicket(22l);
        Assertions.assertThat(trainTicketDTO.getTrainSeatDto().getId()).isEqualTo(trainSeat.getId());
        Assertions.assertThat(trainTicketDTO.getTrainSeatDto().getSeatBookingStatus()).isEqualTo(SeatBookingStatus.VACANT.toString());
        Assertions.assertThat(trainTicketDTO.getTicketStatus()).isEqualTo(TicketStatus.CANCELLED.toString());
    }

    @Test
    public void testModifyTrainTicketByRequest(){
        given(trainTicketRepository.findById(22l)).willReturn(Optional.of(trainTicket));
        given(trainSeatsRepository.findFirstBySeatBookingStatusAndTrainSchedule(SeatBookingStatus.VACANT, trainTicket.getTrainSeat().getTrainSchedule())).willReturn(Optional.of(modifiedTrainSeat));
        given(trainTicketRepository.save(any())).willReturn(modifiedTrainTicket);

        TrainTicketDTO trainTicketDTO = trainTicketService.modifyTrainTicketByRequest(new ModifyTrainTicketRequest(1l, 22l, null));
        Assertions.assertThat(trainTicketDTO.getTicketStatus()).isEqualTo(TicketStatus.BOOKED.toString());
        Assertions.assertThat(trainTicketDTO.getTrainSeatDto().getSeatBookingStatus()).isEqualTo(SeatBookingStatus.RESERVED.toString());
    }

    @Test
    public void testCancelTrainTicketThrowsExceptionIfTicketIsAlreadyCancelled(){
        trainTicket.setTicketStatus(TicketStatus.CANCELLED);
        given(trainTicketRepository.findById(22l)).willReturn(Optional.of(trainTicket));

        Assertions.assertThatThrownBy(() -> trainTicketService.cancelTrainTicketForUserRequest(new CancelTrainTicketRequest(22l, 1l))).isInstanceOf(InvalidRequestParametersException.class);

    }

    @Test
    public void testGetAllTrainTicketsForTrainScheduleAndSectionName(){
        when(trainScheduleRepository.findById(2l)).thenReturn(Optional.of(trainSchedule));
        when(trainSeatsRepository.findAllByTrainScheduleAndSectionName(trainSchedule, SectionName.A)).thenReturn(trainSeats);
        when(trainTicketRepository.findAllByTrainSeatInAndTicketStatus(trainSeats, TicketStatus.BOOKED)).thenReturn(trainTicketList);

        List<TrainTicketDTO> trainTicketDTOS = trainTicketService.getAllTrainTicketsForTrainScheduleAndSectionName(2l, SectionName.A.name());
        Assertions.assertThat(trainTicketDTOS.size()).isEqualTo(2);
    }
}
