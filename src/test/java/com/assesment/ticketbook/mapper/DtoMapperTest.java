package com.assesment.ticketbook.mapper;

import com.assesment.ticketbook.entity.*;
import com.assesment.ticketbook.entity.dto.*;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Date;


public class DtoMapperTest {

    private static User user1, user2;
    static {
        user1 = new User(1L, "Test", "User", "testUser@test.com");
        user2 = new User(2L, "Test", "User2", "testUser2@test.com");
    }

    @Test
    public void testToUserDto(){
        UserDTO userDTO = DtoMapper.toUserDto(user1);

        Assertions.assertThat(userDTO.getId()).isEqualTo(user1.getId());
        Assertions.assertThat(userDTO.getFirstName()).isEqualTo(user1.getFirstName());
        Assertions.assertThat(userDTO.getLastName()).isEqualTo(user1.getLastName());
        Assertions.assertThat(userDTO.getEmailAddress()).isEqualTo(user1.getEmailAddress());
    }

    @Test
    public void testToUser(){
        UserDTO userDTO = new UserDTO(1L, "Test", "User", "testUser@test.com");

        User user = DtoMapper.toUser(userDTO);
        Assertions.assertThat(user.getId()).isEqualTo(userDTO.getId());
        Assertions.assertThat(user.getFirstName()).isEqualTo(userDTO.getFirstName());
        Assertions.assertThat(user.getLastName()).isEqualTo(userDTO.getLastName());
        Assertions.assertThat(user.getEmailAddress()).isEqualTo(userDTO.getEmailAddress());
    }

    @Test
    public void testToTrainDetailDto(){
        TrainDetail trainDetail = new TrainDetail(20l, "Testing Train", StationName.PARIS, StationName.LONDON);

        TrainDetailDTO trainDetailDTO = DtoMapper.toTrainDetailDto(trainDetail);
        Assertions.assertThat(trainDetailDTO.getId()).isEqualTo(trainDetail.getId());
        Assertions.assertThat(trainDetailDTO.getTrainName()).isEqualTo(trainDetail.getTrainName());
        Assertions.assertThat(trainDetailDTO.getStationFrom()).isEqualTo(trainDetail.getStationFrom().name());
        Assertions.assertThat(trainDetailDTO.getStationTo()).isEqualTo(trainDetail.getStationTo().name());
    }

    @Test
    public void testToTrainScheduleDto(){
        TrainDetail trainDetail = new TrainDetail(20l, "Testing Train", StationName.PARIS, StationName.LONDON);
        TrainSchedule trainSchedule = new TrainSchedule(12l, trainDetail, new Date(), 50d);
        TrainScheduleDTO trainScheduleDTO = DtoMapper.toTrainScheduleDto(trainSchedule);
        Assertions.assertThat(trainScheduleDTO.getId()).isEqualTo(trainSchedule.getId());
        Assertions.assertThat(trainScheduleDTO.getTrainDetailDTO().getId()).isEqualTo(trainDetail.getId());
        Assertions.assertThat(trainScheduleDTO.getCost()).isEqualTo(trainSchedule.getCost());
    }

    @Test
    public void testToTrainSeatDto(){
        TrainDetail trainDetail = new TrainDetail(20l, "Testing Train", StationName.PARIS, StationName.LONDON);
        TrainSchedule trainSchedule = new TrainSchedule(12l, trainDetail, new Date(), 50d);

        TrainSeat trainSeat = new TrainSeat(123l, trainSchedule, SectionName.A, 234, SeatBookingStatus.RESERVED);
        TrainSeatDTO trainSeatDTO = DtoMapper.toTrainSeatDto(trainSeat);

        Assertions.assertThat(trainSeatDTO.getId()).isEqualTo(trainSeat.getId());
        Assertions.assertThat(trainSeatDTO.getTrainScheduleDto().getId()).isEqualTo(trainSchedule.getId());
        Assertions.assertThat(trainSeatDTO.getSeatBookingStatus()).isEqualTo(trainSeat.getSeatBookingStatus().name());
    }

    @Test
    public void testToTrainTicketDto(){
        TrainDetail trainDetail = new TrainDetail(20l, "Testing Train", StationName.PARIS, StationName.LONDON);
        TrainSchedule trainSchedule = new TrainSchedule(12l, trainDetail, new Date(), 50d);
        TrainSeat trainSeat = new TrainSeat(123l, trainSchedule, SectionName.A, 234, SeatBookingStatus.RESERVED);
        TrainTicket trainTicket = new TrainTicket(2011l, user1, trainSeat, 50d, TicketStatus.BOOKED);

        TrainTicketDTO trainTicketDTO = DtoMapper.toTrainTicketDto(trainTicket);

        Assertions.assertThat(trainTicketDTO.getId()).isEqualTo(trainTicket.getId());
        Assertions.assertThat(trainTicketDTO.getUserDto().getId()).isEqualTo(user1.getId());
        Assertions.assertThat(trainTicketDTO.getUserDto().getEmailAddress()).isEqualTo(user1.getEmailAddress());
        Assertions.assertThat(trainTicketDTO.getTrainSeatDto().getId()).isEqualTo(trainSeat.getId());
    }
}
