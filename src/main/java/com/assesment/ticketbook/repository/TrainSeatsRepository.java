package com.assesment.ticketbook.repository;

import com.assesment.ticketbook.entity.SeatBookingStatus;
import com.assesment.ticketbook.entity.SectionName;
import com.assesment.ticketbook.entity.TrainSchedule;
import com.assesment.ticketbook.entity.TrainSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrainSeatsRepository extends JpaRepository<TrainSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<TrainSeat> findFirstBySeatBookingStatusAndTrainSchedule(SeatBookingStatus seatBookingStatus, TrainSchedule trainSchedule);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT trseat from TrainSeat trseat WHERE trseat.id = :id")
    Optional<TrainSeat> findByIdForUpdate(Long id);


    List<TrainSeat> findAllByTrainSchedule(TrainSchedule trainSchedule);

    List<TrainSeat> findAllByTrainScheduleAndSectionName(TrainSchedule trainSchedule, SectionName sectionName);
}
