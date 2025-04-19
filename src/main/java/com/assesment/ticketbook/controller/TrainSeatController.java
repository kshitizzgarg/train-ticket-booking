package com.assesment.ticketbook.controller;

import com.assesment.ticketbook.entity.dto.TrainSeatDTO;
import com.assesment.ticketbook.service.TrainSeatService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/train-seat")
public class TrainSeatController {

    TrainSeatService trainSeatService;

    public TrainSeatController(TrainSeatService trainSeatService) {
        this.trainSeatService = trainSeatService;
    }

    @GetMapping("/train-schedule/{trainScheduleId}")
    public List<TrainSeatDTO> getAllSeatsForATrainSchedule(@PathVariable @NotNull Long trainScheduleId){
        return trainSeatService.getAllTrainSeatsForTrainSchedule(trainScheduleId);
    }

}
