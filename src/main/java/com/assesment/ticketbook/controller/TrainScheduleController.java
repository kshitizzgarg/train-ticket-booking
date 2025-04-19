package com.assesment.ticketbook.controller;

import com.assesment.ticketbook.entity.TrainSchedule;
import com.assesment.ticketbook.entity.dto.TrainDetailDTO;
import com.assesment.ticketbook.entity.dto.TrainScheduleDTO;
import com.assesment.ticketbook.entity.request.CreateNewTrainScheduleRequest;
import com.assesment.ticketbook.service.TrainScheduleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train-schedule")
public class TrainScheduleController {

    private TrainScheduleService trainScheduleService;

    public TrainScheduleController(TrainScheduleService trainScheduleService) {
        this.trainScheduleService = trainScheduleService;
    }

    @GetMapping("/train-detail-id/{trainDetailId}")
    public ResponseEntity<List<TrainScheduleDTO>> getAllTrainSchedulesByTrainDetailId(@PathVariable @NotNull Long trainDetailId){
        List<TrainScheduleDTO> trainScheduleDTOS = trainScheduleService.getAllTrainSchedulesForTrainDetailId(trainDetailId);
        return new ResponseEntity<>(trainScheduleDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainScheduleDTO> createNewTrainSchedule(@RequestBody @Valid CreateNewTrainScheduleRequest createNewTrainScheduleRequest){
        TrainScheduleDTO trainSchedule = trainScheduleService.createNewTrainSchedule(createNewTrainScheduleRequest);
        return new ResponseEntity(trainSchedule, HttpStatus.OK);
    }


}
