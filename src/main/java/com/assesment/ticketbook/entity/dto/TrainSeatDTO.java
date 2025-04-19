package com.assesment.ticketbook.entity.dto;


public class TrainSeatDTO {

    private Long id;

    private TrainScheduleDTO trainScheduleDto;

    private String sectionName;

    private Integer seatNumber;

    private String seatBookingStatus;

    public TrainSeatDTO() {
    }

    public TrainSeatDTO(Long id, TrainScheduleDTO trainScheduleDto, String sectionName, Integer seatNumber, String seatBookingStatus) {
        this.id = id;
        this.trainScheduleDto = trainScheduleDto;
        this.sectionName = sectionName;
        this.seatNumber = seatNumber;
        this.seatBookingStatus = seatBookingStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainScheduleDTO getTrainScheduleDto() {
        return trainScheduleDto;
    }

    public void setTrainScheduleDto(TrainScheduleDTO trainScheduleDto) {
        this.trainScheduleDto = trainScheduleDto;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatBookingStatus() {
        return seatBookingStatus;
    }

    public void setSeatBookingStatus(String seatBookingStatus) {
        this.seatBookingStatus = seatBookingStatus;
    }
}
