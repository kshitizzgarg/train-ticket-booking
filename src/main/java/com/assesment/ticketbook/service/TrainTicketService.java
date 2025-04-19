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
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class TrainTicketService {

    UserRepository userRepository;

    TrainTicketRepository trainTicketRepository;

    TrainScheduleRepository trainScheduleRepository;

    TrainSeatsRepository trainSeatsRepository;

    public TrainTicketService(UserRepository userRepository, TrainTicketRepository trainTicketRepository, TrainScheduleRepository trainScheduleRepository, TrainSeatsRepository trainSeatsRepository) {
        this.userRepository = userRepository;
        this.trainTicketRepository = trainTicketRepository;
        this.trainScheduleRepository = trainScheduleRepository;
        this.trainSeatsRepository = trainSeatsRepository;
    }

    @Transactional
    public TrainTicketDTO bookNewTrainTicket(BookTrainTicketRequest bookTrainTicketRequest){
        User user = userRepository.getUserByFirstNameAndLastNameAndEmailAddress(bookTrainTicketRequest.getFirstName(), bookTrainTicketRequest.getLastName(), bookTrainTicketRequest.getEmailAddress());
        if(user==null){
            user=userRepository.save(new User(null, bookTrainTicketRequest.getFirstName(), bookTrainTicketRequest.getLastName(), bookTrainTicketRequest.getEmailAddress()));
        }
        Optional<TrainSchedule> trainScheduleOptional = trainScheduleRepository.findById(bookTrainTicketRequest.getTrainScheduleId());
        if(trainScheduleOptional.isEmpty()){
            throw new InvalidRequestParametersException("No Trains found for scheduleId "+bookTrainTicketRequest.getTrainScheduleId());
        }
        Optional<TrainSeat> trainSeat = trainSeatsRepository.findFirstBySeatBookingStatusAndTrainSchedule(SeatBookingStatus.VACANT, trainScheduleOptional.get());
        if(trainSeat.isEmpty()){
            throw new InvalidRequestParametersException("No Vacant Train seat found");
        }
        TrainTicket trainTicket = new TrainTicket(null, user, trainSeat.get(), trainScheduleOptional.get().getCost().doubleValue(), TicketStatus.BOOKED);
        TrainTicket savedTrainTicket = trainTicketRepository.save(trainTicket);
        trainSeat.get().setSeatBookingStatus(SeatBookingStatus.RESERVED);
        trainSeatsRepository.save(trainSeat.get());
        TrainTicketDTO trainTicketDTO = DtoMapper.toTrainTicketDto(savedTrainTicket);
        return trainTicketDTO;
    }

    @Transactional
    public TrainTicketDTO cancelTrainTicket(Long ticketId){
        Optional<TrainTicket> trainTicketOptional = trainTicketRepository.findById(ticketId);
        if(trainTicketOptional.isEmpty())
            throw new InvalidRequestParametersException("No Ticket found with Id "+trainTicketOptional.get().getId());
        if(trainTicketOptional.get().getTicketStatus().equals(TicketStatus.CANCELLED))
            throw new InvalidRequestParametersException("Ticket is already cancelled.");
        TrainTicket trainTicket = trainTicketOptional.get();
        trainTicket.setTicketStatus(TicketStatus.CANCELLED);
        TrainSeat trainSeat = trainTicket.getTrainSeat();
        trainSeat.setSeatBookingStatus(SeatBookingStatus.VACANT);
        trainSeatsRepository.save(trainSeat);
        TrainTicket savedTrainTicket = trainTicketRepository.save(trainTicket);
        return DtoMapper.toTrainTicketDto(savedTrainTicket);
    }

    @Transactional
    public TrainTicketDTO cancelTrainTicketForUserRequest(CancelTrainTicketRequest cancelTrainTicketRequest){
        Optional<TrainTicket> trainTicketOptional = trainTicketRepository.findById(cancelTrainTicketRequest.getTrainTicketId());
        if(trainTicketOptional.isEmpty())
            throw new InvalidRequestParametersException("No Ticket found with Id "+cancelTrainTicketRequest.getTrainTicketId());
        if(trainTicketOptional.get().getUser().getId()!=cancelTrainTicketRequest.getUserId()){
            throw new InvalidRequestParametersException(String.format("No ticket found for Userid %s with ticket id %s", cancelTrainTicketRequest.getUserId(), cancelTrainTicketRequest.getTrainTicketId()));
        }
        if(trainTicketOptional.get().getTicketStatus().equals(TicketStatus.CANCELLED))
            throw new InvalidRequestParametersException("Ticket is already cancelled.");
        TrainTicket trainTicket = trainTicketOptional.get();
        trainTicket.setTicketStatus(TicketStatus.CANCELLED);
        TrainSeat trainSeat = trainTicket.getTrainSeat();
        trainSeat.setSeatBookingStatus(SeatBookingStatus.VACANT);
        trainSeatsRepository.save(trainSeat);
        TrainTicket savedTrainTicket = trainTicketRepository.save(trainTicket);
        return DtoMapper.toTrainTicketDto(savedTrainTicket);
    }

    @Transactional
    public TrainTicketDTO modifyTrainTicketByRequest(ModifyTrainTicketRequest modifyTrainTicketRequest){
        Optional<TrainTicket> trainTicketOptional = trainTicketRepository.findById(modifyTrainTicketRequest.getExistingTrainTicketId());
        if(trainTicketOptional.isEmpty())
                throw new InvalidRequestParametersException("No Ticket found with Id "+modifyTrainTicketRequest.getExistingTrainTicketId());
        if(trainTicketOptional.get().getUser().getId()!=modifyTrainTicketRequest.getUserId()){
            throw new InvalidRequestParametersException(String.format("No ticket found for Userid %s with ticket id %s", modifyTrainTicketRequest.getUserId(), modifyTrainTicketRequest.getExistingTrainTicketId()));
        }
        if(trainTicketOptional.get().getTicketStatus().equals(TicketStatus.CANCELLED))
            throw new InvalidRequestParametersException("Ticket is already cancelled.");
        TrainTicket trainTicket = trainTicketOptional.get();
        trainTicket.setTicketStatus(TicketStatus.CANCELLED);
        Optional<TrainSeat> newTrainSeatOptional;
        if(modifyTrainTicketRequest.getNewTrainSeatId()!=null && modifyTrainTicketRequest.getNewTrainSeatId()>0){
            newTrainSeatOptional= trainSeatsRepository.findByIdForUpdate(modifyTrainTicketRequest.getNewTrainSeatId());

        }
        else{
            newTrainSeatOptional = trainSeatsRepository.findFirstBySeatBookingStatusAndTrainSchedule(SeatBookingStatus.VACANT, trainTicket.getTrainSeat().getTrainSchedule());
        }
        if(newTrainSeatOptional.isEmpty())
            throw new InvalidRequestParametersException("No other Train seat available apart from the one already assigned.");

        TrainSeat newSeat = newTrainSeatOptional.get();
        newSeat.setSeatBookingStatus(SeatBookingStatus.RESERVED);

        TrainSeat modifiedSeat = trainTicket.getTrainSeat();
        modifiedSeat.setSeatBookingStatus(SeatBookingStatus.VACANT);

        TrainTicket newTrainTicket = new TrainTicket(null, trainTicket.getUser(), newSeat, newSeat.getTrainSchedule().getCost().doubleValue(), TicketStatus.BOOKED);
        trainTicketRepository.save(trainTicket);
        TrainTicket savedTicket = trainTicketRepository.save(newTrainTicket);
        trainSeatsRepository.save(modifiedSeat);
        trainSeatsRepository.save(newSeat);

        return DtoMapper.toTrainTicketDto(savedTicket);
    }

    public List<TrainTicketDTO> getAllTrainTicketsForTrainScheduleAndSectionName(Long trainScheduleId, String sectionName){
        Optional<TrainSchedule> trainScheduleOptional = trainScheduleRepository.findById(trainScheduleId);
        if(trainScheduleOptional.isEmpty())
            throw new InvalidRequestParametersException("No Train Schedule found for id "+trainScheduleId);
        List<TrainSeat> allTrainSeats = trainSeatsRepository.findAllByTrainScheduleAndSectionName(trainScheduleOptional.get(), SectionName.valueOf(sectionName.toUpperCase()));
        if(allTrainSeats.isEmpty())
            throw new InvalidRequestParametersException("No Train Seats found for Train Schedule id "+trainScheduleId);
        List<TrainTicket> allTrainTickets = trainTicketRepository.findAllByTrainSeatInAndTicketStatus(allTrainSeats, TicketStatus.BOOKED);
        return allTrainTickets.stream().map(ticket -> DtoMapper.toTrainTicketDto(ticket)).collect(Collectors.toList());
    }

    public List<TrainTicketDTO> getAllTrainTicketsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty())
            throw new InvalidRequestParametersException("No User found for id " + userId);
        List<TrainTicket> allTrainTickets = trainTicketRepository.findAllByUser(userOptional.get());
        return allTrainTickets.stream().map(ticket -> DtoMapper.toTrainTicketDto(ticket)).collect(Collectors.toList());
    }

}
