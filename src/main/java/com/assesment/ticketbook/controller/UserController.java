package com.assesment.ticketbook.controller;

import java.util.List;
import java.util.stream.Collectors;


import com.assesment.ticketbook.entity.User;
import com.assesment.ticketbook.entity.dto.UserDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.entity.request.CreateUserRequest;
import com.assesment.ticketbook.repository.TrainScheduleRepository;
import com.assesment.ticketbook.repository.TrainSeatsRepository;
import com.assesment.ticketbook.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<User> allUsers = userService.getAllUsers();
        List<UserDTO> userDTOS = allUsers.stream().map(user -> DtoMapper.toUserDto(user)).collect(Collectors.toList());
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable @NotNull Long id) {

        User user = userService.getUserById(id);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(DtoMapper.toUserDto(user), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmailAddress(@PathVariable @NotBlank String email) {

        User user = userService.getUserByEmailAddress(email);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(DtoMapper.toUserDto(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createNewUser(@RequestBody @Valid CreateUserRequest createUserRequest) throws Exception {
        UserDTO userDTO = new UserDTO(0, createUserRequest.getFirstName(), createUserRequest.getLastName(), createUserRequest.getEmailAddress());
        User savedUser = userService.createNewUser(userDTO);

        return new ResponseEntity(DtoMapper.toUserDto(savedUser), HttpStatus.OK);
    }
}
