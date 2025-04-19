package com.assesment.ticketbook.integration;

import com.assesment.ticketbook.controller.UserController;
import com.assesment.ticketbook.entity.User;
import com.assesment.ticketbook.entity.dto.UserDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.entity.request.CreateUserRequest;
import com.assesment.ticketbook.integration.base.AbstractIntegrationTest;
import com.assesment.ticketbook.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    UserRepository userRepository;

    private static final String firstName = "TestUser";
    private static final String lastName = "Integration";
    private static final String emailAddress = "testuser@integration.com";
    private static final String firstNameUser2 = "TestUser2";
    private static final String lastNameUser2 = "Integration2";
    private static final String emailAddressUser2 = "testuser2@integration.com";


    @Test
    @Order(1)
    @DisplayName("Happy Case New User is created")
    public void testCreateNewUser() throws Exception {
        CreateUserRequest createUserRequest = new CreateUserRequest(firstName, lastName, emailAddress);
        UserDTO userDTO = performPostRequestExpectedSuccess("/user", createUserRequest, UserDTO.class);
        Assertions.assertThat(userDTO.getId()).isGreaterThan(0l);
        Assertions.assertThat(userDTO.getFirstName()).isEqualTo(firstName);
        Assertions.assertThat(userDTO.getLastName()).isEqualTo(lastName);
        Assertions.assertThat(userDTO.getEmailAddress()).isEqualTo(emailAddress);

    }

    @Test
    @Order(2)
    @DisplayName("Happy Case Get All Users")
    public void testGetAllUsers() throws Exception {
        List<UserDTO> userDTOList =  performGetRequestExpectedSuccess("/user", List.class);
        Assertions.assertThat(userDTOList.size()).isEqualTo(2);
    }

    @Test
    @Order(3)
    @DisplayName("Happy Case Get User By Id")
    public void testGetUserById() throws Exception {
        User user = new User(null, firstNameUser2, lastNameUser2, emailAddressUser2);
        User savedUser = userRepository.save(user);
        UserDTO userDTO = performGetRequestExpectedSuccess("/user/id/"+savedUser.getId(),  UserDTO.class);
        Assertions.assertThat(userDTO.getId()).isEqualTo(savedUser.getId());
        Assertions.assertThat(userDTO.getFirstName()).isEqualTo(firstNameUser2);
        Assertions.assertThat(userDTO.getEmailAddress()).isEqualTo(emailAddressUser2);
    }

    @Test
    @Order(4)
    @DisplayName("Happy Case Get user by email")
    public void testGetUserByEmail() throws Exception {
        UserDTO userDTO = performGetRequestExpectedSuccess("/user/email/"+emailAddress,  UserDTO.class);
        Assertions.assertThat(userDTO.getId()).isGreaterThan(0l);
        Assertions.assertThat(userDTO.getFirstName()).isEqualTo(firstName);
        Assertions.assertThat(userDTO.getLastName()).isEqualTo(lastName);
    }

    @Test
    @Order(5)
    @DisplayName("Unhappy case - user not found for email")
    public void testGetUserByEmailThrowsErrorInCaseOfNonExistentEmail() throws Exception {
        UserDTO userDTO = performGetRequestExpectedSuccess("/user/email/"+emailAddress,  UserDTO.class);
        User user = DtoMapper.toUser(userDTO);
        userRepository.delete(user);
        performGetRequestExpectedError("/user/email/"+emailAddress, status().is4xxClientError());
    }

    @Test
    @Order(6)
    @DisplayName("Unhappy Case - user not found for id")
    public void testGetUserByIdThrowsErrorIfIdNotPresent() throws Exception {
        User user = userRepository.getUserByFirstNameAndLastNameAndEmailAddress(firstNameUser2, lastNameUser2, emailAddressUser2);
        userRepository.delete(user);
        performGetRequestExpectedError("/user/id/"+user.getId(), status().is4xxClientError());
    }



}
