package com.assesment.ticketbook.controller;

import com.assesment.ticketbook.entity.dto.TrainTicketDTO;
import com.assesment.ticketbook.entity.request.BookTrainTicketRequest;
import com.assesment.ticketbook.entity.request.CancelTrainTicketRequest;
import com.assesment.ticketbook.entity.request.ModifyTrainTicketRequest;
import com.assesment.ticketbook.service.TrainTicketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train-ticket")
public class TrainTicketController {

    TrainTicketService trainTicketService;

    public TrainTicketController(TrainTicketService trainTicketService) {
        this.trainTicketService = trainTicketService;
    }

    @PostMapping
    public ResponseEntity<TrainTicketDTO> bookTrainTicketForUser(@RequestBody @Valid BookTrainTicketRequest bookTrainTicketRequest){
        TrainTicketDTO trainTicketDTO = trainTicketService.bookNewTrainTicket(bookTrainTicketRequest);
        return new ResponseEntity(trainTicketDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{trainTicketId}")
    public ResponseEntity<TrainTicketDTO> cancelTrainTicket(@PathVariable @NotNull Long trainTicketId){
        TrainTicketDTO trainTicketDTO = trainTicketService.cancelTrainTicket(trainTicketId);
        return new ResponseEntity<>(trainTicketDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<TrainTicketDTO> cancelTrainTicketForRequest(@RequestBody @Valid CancelTrainTicketRequest cancelTrainTicketRequest){
        TrainTicketDTO trainTicketDTO = trainTicketService.cancelTrainTicketForUserRequest(cancelTrainTicketRequest);
        return new ResponseEntity<>(trainTicketDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TrainTicketDTO> modifyTrainTicketForRequest(@RequestBody @Valid ModifyTrainTicketRequest modifyTrainTicketRequest){
        TrainTicketDTO trainTicketDTO = trainTicketService.modifyTrainTicketByRequest(modifyTrainTicketRequest);
        return new ResponseEntity<>(trainTicketDTO, HttpStatus.OK);
    }

    @GetMapping("train-schedule-id/{trainScheduleId}/section/{sectionName}")
    public ResponseEntity<List<TrainTicketDTO>> getAllTicketsByTrainScheduleIdAndSectionName(@PathVariable @NotNull Long trainScheduleId, @PathVariable @NotNull String sectionName){
        List<TrainTicketDTO> trainTicketDTOS = trainTicketService.getAllTrainTicketsForTrainScheduleAndSectionName(trainScheduleId, sectionName);
        return new ResponseEntity<>(trainTicketDTOS, HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<TrainTicketDTO>> getAllTrainTicketsByUserId(@PathVariable @NotNull Long userId){
        List<TrainTicketDTO> trainTicketDTOS = trainTicketService.getAllTrainTicketsByUserId(userId);
        return new ResponseEntity<>(trainTicketDTOS, HttpStatus.OK);
    }
}
