package com.assesment.ticketbook.entity.request;

import jakarta.validation.constraints.NotNull;

public class GetAllTicketsByTrainIdAndSectionNameRequest {

    @NotNull
    private Long trainId;

    @NotNull
    private String sectionName;

}
