package com.assesment.ticketbook.repository;

import com.assesment.ticketbook.entity.StationName;
import com.assesment.ticketbook.entity.TrainDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainDetailsRepository extends JpaRepository<TrainDetail, Long> {
    Optional<TrainDetail> findByStationFromAndStationTo(StationName stationFrom, StationName stationTo);

}
