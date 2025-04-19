package com.assesment.ticketbook.service;

import com.assesment.ticketbook.entity.StationName;
import com.assesment.ticketbook.entity.TrainDetail;
import com.assesment.ticketbook.entity.dto.TrainDetailDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.entity.request.CreateNewTrainDetailRequest;
import com.assesment.ticketbook.exception.InvalidRequestParametersException;
import com.assesment.ticketbook.exception.NoResourceFoundForGivenRequestException;
import com.assesment.ticketbook.repository.TrainDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainDetailService {
    private static final Logger log = LoggerFactory.getLogger(TrainDetailService.class);

    TrainDetailsRepository trainDetailsRepository;

    public TrainDetailService(TrainDetailsRepository trainDetailsRepository) {
        this.trainDetailsRepository = trainDetailsRepository;
    }

    public List<TrainDetailDTO> getAllTrainDetails(){
        List<TrainDetail> allTrainDetails = trainDetailsRepository.findAll();
        return allTrainDetails.stream().map(trainDetail -> DtoMapper.toTrainDetailDto(trainDetail)).collect(Collectors.toList());
    }

    public TrainDetailDTO getTrainDetailByFromAndToStation(String fromStation, String toStation){
        StationName fromStationEnum = StationName.valueOf(fromStation);
        StationName toStationEnum = StationName.valueOf(toStation);
        Optional<TrainDetail> trainDetailOptional = trainDetailsRepository.findByStationFromAndStationTo(fromStationEnum, toStationEnum);
        if(trainDetailOptional.isEmpty())
            throw new NoResourceFoundForGivenRequestException("No Trains found for given stations");
        return DtoMapper.toTrainDetailDto(trainDetailOptional.get());
    }

    public TrainDetailDTO createNewTrainDetail(CreateNewTrainDetailRequest createNewTrainDetailRequest){
        StationName fromStation;
        StationName toStation;
        try {
            fromStation = StationName.valueOf(createNewTrainDetailRequest.getStationNameFrom());
            toStation = StationName.valueOf(createNewTrainDetailRequest.getStationNameTo());
        } catch (Exception e) {
            throw new InvalidRequestParametersException("Invalid Station names");
        }
        TrainDetail trainDetail = new TrainDetail(null, createNewTrainDetailRequest.getTrainName(), fromStation, toStation);
        return DtoMapper.toTrainDetailDto(trainDetail);
    }

}
