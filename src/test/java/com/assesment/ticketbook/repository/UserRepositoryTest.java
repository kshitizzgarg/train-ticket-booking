package com.assesment.ticketbook.repository;

import com.assesment.ticketbook.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    private static String userEmail = "testUser@test.com";
    private static String firstName = "Test";
    private static String lastName = "User";
    private User user;

    @BeforeEach
    public void setUpData(){

        user = new User(null, firstName, lastName, userEmail);
        userRepository.save(user);
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUserByEmailAddress(){


        //Action
        User returnedUser = userRepository.getUserByEmailAddress(userEmail);
        Assertions.assertThat(returnedUser.getEmailAddress()).isEqualTo(userEmail);
        Assertions.assertThat(user.getId()).isEqualTo(returnedUser.getId());
        Assertions.assertThat(user.getFirstName()).isEqualTo(returnedUser.getFirstName());
        Assertions.assertThat(user.getLastName()).isEqualTo(returnedUser.getLastName());
    }

    @Test
    public void testGetUserByFirstNameLastNameEmailAddress(){
        User returnedUser = userRepository.getUserByFirstNameAndLastNameAndEmailAddress(firstName, lastName, userEmail);
        Assertions.assertThat(returnedUser.getEmailAddress()).isEqualTo(userEmail);
        Assertions.assertThat(user.getId()).isEqualTo(returnedUser.getId());
        Assertions.assertThat(user.getFirstName()).isEqualTo(returnedUser.getFirstName());
        Assertions.assertThat(user.getLastName()).isEqualTo(returnedUser.getLastName());
    }
}
