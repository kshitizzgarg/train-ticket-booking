package com.assesment.ticketbook.integration;

import com.assesment.ticketbook.entity.SeatBookingStatus;
import com.assesment.ticketbook.entity.TicketStatus;
import com.assesment.ticketbook.entity.dto.TrainTicketDTO;
import com.assesment.ticketbook.entity.request.BookTrainTicketRequest;
import com.assesment.ticketbook.entity.request.ModifyTrainTicketRequest;
import com.assesment.ticketbook.integration.base.AbstractIntegrationTest;
import com.assesment.ticketbook.repository.TrainTicketRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TrainTicketControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    TrainTicketRepository trainTicketRepository;

    @Test
    @DisplayName("Happy Case - Book ticket")
    public void testBookTrainTicketForUser() throws Exception {
        BookTrainTicketRequest bookTrainTicketRequest = new BookTrainTicketRequest("Test", "User-Int","testUserInt@test.com", 1l, 12345l);
        TrainTicketDTO trainTicketDTO = performPostRequestExpectedSuccess("/train-ticket", bookTrainTicketRequest, TrainTicketDTO.class);

        Assertions.assertThat(trainTicketDTO.getTrainSeatDto().getId()).isGreaterThan(0l);
        Assertions.assertThat(trainTicketDTO.getTrainSeatDto().getSeatBookingStatus()).isEqualTo(SeatBookingStatus.RESERVED.toString());
        Assertions.assertThat(trainTicketDTO.getId()).isGreaterThan(0L);
        Assertions.assertThat(trainTicketDTO.getTicketStatus()).isEqualTo(TicketStatus.BOOKED.toString());
    }

    @Test
    @DisplayName("Happy Case - Cancel Ticket")
    public void testCancelTrainTicketForUser() throws Exception {
        BookTrainTicketRequest bookTrainTicketRequest = new BookTrainTicketRequest("Test", "User-Int","testUserInt@test.com", 1l, 12345l);
        TrainTicketDTO trainTicketDTO = performPostRequestExpectedSuccess("/train-ticket", bookTrainTicketRequest, TrainTicketDTO.class);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/train-ticket/"+trainTicketDTO.getId())).andExpect(status().is2xxSuccessful()).andReturn();
        TrainTicketDTO trainTicketDTO1 = convertStringToClass(result.getResponse().getContentAsString(), TrainTicketDTO.class);
        Assertions.assertThat(trainTicketDTO1.getTicketStatus()).isEqualTo(TicketStatus.CANCELLED.toString());
        Assertions.assertThat(trainTicketDTO1.getId()).isEqualTo(trainTicketDTO.getId());
    }

    @Test
    @DisplayName("Happy Case - Modify Train Ticket")
    public void testModifyTrainTicket() throws Exception {
        BookTrainTicketRequest bookTrainTicketRequest = new BookTrainTicketRequest("Test", "User-Int","testUserInt@test.com", 1l, 12345l);
        TrainTicketDTO trainTicketDTO = performPostRequestExpectedSuccess("/train-ticket", bookTrainTicketRequest, TrainTicketDTO.class);
        ModifyTrainTicketRequest modifyTrainTicketRequest = new ModifyTrainTicketRequest(trainTicketDTO.getUserDto().getId(), trainTicketDTO.getId(), null);
        TrainTicketDTO modifiedTrainTicketDTO = performPutRequestExpectedSuccess("/train-ticket", modifyTrainTicketRequest, TrainTicketDTO.class);
        Assertions.assertThat(modifiedTrainTicketDTO.getId()).isNotEqualTo(trainTicketDTO.getId());
        Assertions.assertThat(modifiedTrainTicketDTO.getUserDto().getId()).isEqualTo(trainTicketDTO.getUserDto().getId());
        Assertions.assertThat(modifiedTrainTicketDTO.getTicketStatus()).isEqualTo(TicketStatus.BOOKED.toString());
    }

    @Test
    @DisplayName("Unhappy Case - Modify Train Ticket - Original Ticket not found")
    public void testModifyTrainTicketUnhappyCaseOriginalTicketNotFound() throws Exception {
        BookTrainTicketRequest bookTrainTicketRequest = new BookTrainTicketRequest("Test", "User-Int","testUserInt@test.com", 1l, 12345l);
        TrainTicketDTO trainTicketDTO = performPostRequestExpectedSuccess("/train-ticket", bookTrainTicketRequest, TrainTicketDTO.class);
        ModifyTrainTicketRequest modifyTrainTicketRequest = new ModifyTrainTicketRequest(trainTicketDTO.getUserDto().getId(), 0l, null);
        performPutRequestExpectedClientError("/train-ticket", modifyTrainTicketRequest, status().is4xxClientError());
    }


    @Test
    @DisplayName("Unhappy Case - Modify Train Ticket - User Id mismatch")
    public void testModifyTrainTicketUnhappyCaseUserIdMismatch() throws Exception {
        BookTrainTicketRequest bookTrainTicketRequest = new BookTrainTicketRequest("Test", "User-Int","testUserInt@test.com", 1l, 12345l);
        TrainTicketDTO trainTicketDTO = performPostRequestExpectedSuccess("/train-ticket", bookTrainTicketRequest, TrainTicketDTO.class);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/train-ticket/"+trainTicketDTO.getId())).andExpect(status().is2xxSuccessful()).andReturn();
        TrainTicketDTO trainTicketDTO1 = convertStringToClass(result.getResponse().getContentAsString(), TrainTicketDTO.class);
        ModifyTrainTicketRequest modifyTrainTicketRequest = new ModifyTrainTicketRequest(trainTicketDTO.getUserDto().getId(), trainTicketDTO1.getId(), null);
        performPutRequestExpectedClientError("/train-ticket", modifyTrainTicketRequest, status().is4xxClientError());
    }
}
