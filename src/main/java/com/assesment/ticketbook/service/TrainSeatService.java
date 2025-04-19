package com.assesment.ticketbook.service;

import com.assesment.ticketbook.entity.TrainSchedule;
import com.assesment.ticketbook.entity.TrainSeat;
import com.assesment.ticketbook.entity.dto.TrainSeatDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.exception.InvalidRequestParametersException;
import com.assesment.ticketbook.exception.NoResourceFoundForGivenRequestException;
import com.assesment.ticketbook.repository.TrainScheduleRepository;
import com.assesment.ticketbook.repository.TrainSeatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainSeatService {
    TrainScheduleRepository trainScheduleRepository;
    TrainSeatsRepository trainSeatsRepository;

    public TrainSeatService(TrainScheduleRepository trainScheduleRepository, TrainSeatsRepository trainSeatsRepository) {
        this.trainScheduleRepository = trainScheduleRepository;
        this.trainSeatsRepository = trainSeatsRepository;
    }

    public List<TrainSeatDTO> getAllTrainSeatsForTrainSchedule(Long trainScheduleId){
        Optional<TrainSchedule> trainSchedule = trainScheduleRepository.findById(trainScheduleId);
        if(trainSchedule.isEmpty())
            throw new InvalidRequestParametersException("No Train Schedule found for id "+trainScheduleId);
        List<TrainSeat> allTrainSeats = trainSeatsRepository.findAllByTrainSchedule(trainSchedule.get());
        if(allTrainSeats.isEmpty())
            throw new NoResourceFoundForGivenRequestException("No seats found for train schedule id "+trainScheduleId);
        return allTrainSeats.stream().map(seat -> DtoMapper.toTrainSeatDto(seat)).collect(Collectors.toList());
    }
}
