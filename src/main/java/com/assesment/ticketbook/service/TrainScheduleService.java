package com.assesment.ticketbook.service;

import com.assesment.ticketbook.entity.TrainDetail;
import com.assesment.ticketbook.entity.TrainSchedule;
import com.assesment.ticketbook.entity.dto.TrainScheduleDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.entity.request.CreateNewTrainScheduleRequest;
import com.assesment.ticketbook.exception.InvalidRequestParametersException;
import com.assesment.ticketbook.exception.NoResourceFoundForGivenRequestException;
import com.assesment.ticketbook.repository.TrainDetailsRepository;
import com.assesment.ticketbook.repository.TrainScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainScheduleService {

    private TrainScheduleRepository trainScheduleRepository;
    private TrainDetailsRepository trainDetailsRepository;
    private DateTimeFormatter dateTimeFormatter;


    public TrainScheduleService(TrainScheduleRepository trainScheduleRepository, TrainDetailsRepository trainDetailsRepository) {
        this.trainScheduleRepository = trainScheduleRepository;
        this.trainDetailsRepository = trainDetailsRepository;
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ssZ");
    }

    public List<TrainScheduleDTO> getAllTrainSchedulesForTrainDetailId(Long trainDetailId){
        Optional<TrainDetail> trainDetailOptional = trainDetailsRepository.findById(trainDetailId);

        if(trainDetailOptional.isEmpty())
            throw new InvalidRequestParametersException("No Train details found for id "+trainDetailId);

        List<TrainSchedule> allTrainSchedules = trainScheduleRepository.findAllByTrainDetail(trainDetailOptional.get());
        if(allTrainSchedules.isEmpty())
            throw new NoResourceFoundForGivenRequestException("No Train Schedules found for the given train id "+trainDetailId);
        return allTrainSchedules.stream().map(trainSchedule -> DtoMapper.toTrainScheduleDto(trainSchedule)).collect(Collectors.toList());
    }

    public TrainScheduleDTO createNewTrainSchedule(CreateNewTrainScheduleRequest createNewTrainScheduleRequest){
        Date departureDate;
        try{
            departureDate = new Date(Instant.from(dateTimeFormatter.parse(createNewTrainScheduleRequest.getDepartureDate())).toEpochMilli());
        } catch (Exception e){
            throw new InvalidRequestParametersException("Incorrect Date format");
        }
        Optional<TrainDetail> trainDetailOptional = trainDetailsRepository.findById(createNewTrainScheduleRequest.getTrainDetailId());
        if(trainDetailOptional.isEmpty())
            throw new InvalidRequestParametersException(String.format("No such train exists with id %s", createNewTrainScheduleRequest.getTrainDetailId()));

        TrainSchedule trainSchedule = new TrainSchedule(null, trainDetailOptional.get(), departureDate, createNewTrainScheduleRequest.getCost());

        TrainSchedule savedTrainSchedule = trainScheduleRepository.save(trainSchedule);

        return DtoMapper.toTrainScheduleDto(savedTrainSchedule);
    }

}
