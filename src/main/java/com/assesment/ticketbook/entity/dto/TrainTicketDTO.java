package com.assesment.ticketbook.entity.dto;


public class TrainTicketDTO {
    private Long id;

    private UserDTO userDto;

    private TrainSeatDTO trainSeatDto;

    private Double price;

    private String ticketStatus;

    public TrainTicketDTO() {
    }

    public TrainTicketDTO(Long id, UserDTO userDto, TrainSeatDTO trainSeatDto, Double price, String ticketStatus) {
        this.id = id;
        this.userDto = userDto;
        this.trainSeatDto = trainSeatDto;
        this.price = price;
        this.ticketStatus = ticketStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDTO userDto) {
        this.userDto = userDto;
    }

    public TrainSeatDTO getTrainSeatDto() {
        return trainSeatDto;
    }

    public void setTrainSeatDto(TrainSeatDTO trainSeatDto) {
        this.trainSeatDto = trainSeatDto;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
