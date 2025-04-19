package com.assesment.ticketbook.entity.mapper;

import com.assesment.ticketbook.entity.*;
import com.assesment.ticketbook.entity.dto.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class DtoMapper {

    private static ModelMapper modelMapper;
    static {
        modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }


    public static UserDTO toUserDto(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public static User toUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
    public static TrainDetailDTO toTrainDetailDto(TrainDetail trainDetail){
        TrainDetailDTO trainDetailDTO = modelMapper.map(trainDetail, TrainDetailDTO.class);
        return trainDetailDTO;
    }

    public static TrainScheduleDTO toTrainScheduleDto(TrainSchedule trainSchedule){
        TrainScheduleDTO trainScheduleDTO = modelMapper.map(trainSchedule, TrainScheduleDTO.class);
        return trainScheduleDTO;
    }

    public static TrainSeatDTO toTrainSeatDto(TrainSeat trainSeat){
        TrainScheduleDTO trainScheduleDTO = modelMapper.map(trainSeat.getTrainSchedule(), TrainScheduleDTO.class);
        TrainSeatDTO trainSeatDTO = new TrainSeatDTO(trainSeat.getId(), trainScheduleDTO, trainSeat.getSectionName().name(), trainSeat.getSeatNumber(), trainSeat.getSeatBookingStatus().name());
        return trainSeatDTO;
    }

    public static TrainTicketDTO toTrainTicketDto(TrainTicket trainTicket){
        UserDTO userDTO = toUserDto(trainTicket.getUser());
        TrainSeatDTO trainSeatDTO = toTrainSeatDto(trainTicket.getTrainSeat());
        return new TrainTicketDTO(trainTicket.getId(), userDTO, trainSeatDTO, trainTicket.getPrice(), trainTicket.getTicketStatus().name());
    }









}
