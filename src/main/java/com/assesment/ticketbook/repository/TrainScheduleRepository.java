package com.assesment.ticketbook.repository;

import com.assesment.ticketbook.entity.TrainDetail;
import com.assesment.ticketbook.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule, Long> {
    List<TrainSchedule> findAllByTrainDetail(TrainDetail trainDetail);
}
