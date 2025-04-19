package com.assesment.ticketbook.service;

import com.assesment.ticketbook.entity.User;
import com.assesment.ticketbook.entity.dto.UserDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public User getUserByEmailAddress(String emailAddress){
        User user = userRepository.getUserByEmailAddress(emailAddress);
        return user;
    }

    public User createNewUser(UserDTO userDTO) throws Exception {
        User user = userRepository.getUserByFirstNameAndLastNameAndEmailAddress(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmailAddress());
        if(user!=null)
            throw new Exception("User Already exists");
        user = DtoMapper.toUser(userDTO);
        user.setId(null);

        User savedUser = userRepository.save(user);
        return savedUser;
    }

}
