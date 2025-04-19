package com.assesment.ticketbook.controller;


import com.assesment.ticketbook.entity.StationName;
import com.assesment.ticketbook.entity.TrainDetail;
import com.assesment.ticketbook.entity.dto.TrainDetailDTO;
import com.assesment.ticketbook.entity.request.CreateNewTrainDetailRequest;
import com.assesment.ticketbook.service.TrainDetailService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train-detail")
public class TrainDetailController {

    TrainDetailService trainDetailService;

    public TrainDetailController(TrainDetailService trainDetailService) {
        this.trainDetailService = trainDetailService;
    }

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<TrainDetailDTO> getTrainDetailForFromToStationPair(@PathVariable @NotBlank String from, @PathVariable @NotBlank String to) {
        TrainDetailDTO trainDetailDTO = trainDetailService.getTrainDetailByFromAndToStation(from, to);
        return new ResponseEntity<>(trainDetailDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TrainDetailDTO>> getAllTrainDetail() {
        List<TrainDetailDTO> trainDetailDTOS = trainDetailService.getAllTrainDetails();
        return new ResponseEntity<>(trainDetailDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainDetailDTO> saveNewTrainDetail(@RequestBody @Valid CreateNewTrainDetailRequest createNewTrainDetailRequest) {
        TrainDetailDTO trainDetailDTO = trainDetailService.createNewTrainDetail(createNewTrainDetailRequest);
        return new ResponseEntity<>(trainDetailDTO, HttpStatus.OK);
    }
}
