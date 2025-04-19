package com.assesment.ticketbook.service;


import com.assesment.ticketbook.entity.User;
import com.assesment.ticketbook.entity.dto.UserDTO;
import com.assesment.ticketbook.entity.mapper.DtoMapper;
import com.assesment.ticketbook.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    private User user1;
    private User user2;
    private List<User> userList;

    @BeforeEach
    void setupUserServiceTest(){
        userList=new ArrayList<>();
        user1 = new User(1L, "Test", "User", "testUser@test.com");
        user2 = new User(2L, "Test", "User2", "testUser2@test.com");
        userList.add(user1);
        userList.add(user2);
    }

    @Test
    @DisplayName("Happy Case - Get All Users")
    public void testGetAllUsers(){
        given(userRepository.findAll()).willReturn(userList);

        List<User> userListRet = userService.getAllUsers();

        Assertions.assertThat(userListRet.size()).isEqualTo(userList.size());
        Assertions.assertThat(userListRet.containsAll(userList));
    }

    @Test
    @DisplayName("Happy Case - Get User By Id")
    public void testGetUserById(){
        given(userRepository.findById(1L)).willReturn(Optional.of(user1));

        User retUser = userService.getUserById(1l);

        Assertions.assertThat(retUser.getLastName()).isEqualTo(user1.getLastName());
        Assertions.assertThat(retUser.getFirstName()).isEqualTo(user1.getFirstName());
        Assertions.assertThat(retUser.getEmailAddress()).isEqualTo(user1.getEmailAddress());
        Assertions.assertThat(retUser.getId()).isEqualTo(user1.getId());
    }

    @Test
    @DisplayName("Happy Case - Get user by email")
    public void testGetUserByEmail(){

        given(userRepository.getUserByEmailAddress(user2.getEmailAddress())).willReturn(user2);

        User retUser = userService.getUserByEmailAddress("testUser2@test.com");

        Assertions.assertThat(retUser.getLastName()).isEqualTo(user2.getLastName());
        Assertions.assertThat(retUser.getFirstName()).isEqualTo(user2.getFirstName());
        Assertions.assertThat(retUser.getEmailAddress()).isEqualTo(user2.getEmailAddress());
        Assertions.assertThat(retUser.getId()).isEqualTo(user2.getId());
    }

    @Test
    @DisplayName("Happy Case - Create new user")
    public void testCreateNewUser() throws Exception {
        given(userRepository.getUserByFirstNameAndLastNameAndEmailAddress(user1.getFirstName(), user1.getLastName(), user1.getEmailAddress())).willReturn(null);
        given(userRepository.save(argThat(new UserMatchesUser1Matcher()))).willReturn(user1);

        UserDTO userDTO = DtoMapper.toUserDto(user1);
        User retUser = userService.createNewUser(userDTO);

        Assertions.assertThat(retUser.getLastName()).isEqualTo(user1.getLastName());
        Assertions.assertThat(retUser.getFirstName()).isEqualTo(user1.getFirstName());
        Assertions.assertThat(retUser.getEmailAddress()).isEqualTo(user1.getEmailAddress());
        Assertions.assertThat(retUser.getId()).isEqualTo(user1.getId());

    }
    class UserMatchesUser1Matcher implements ArgumentMatcher<User> {
        public boolean matches(User user) {
            return user.getFirstName()==user1.getFirstName() && user.getLastName()==user1.getLastName() && user.getEmailAddress()==user1.getEmailAddress();
        }
        public String toString() {
            //printed in verification errors
            return "Matcher for User";
        }
    }


    @Test
    @DisplayName("UnHappy Case - Create user throws error if duplicate first, last name and email seen")
    public void testCreateNewUserForDuplicateFirstLastNameEmail() throws Exception {
        given(userRepository.getUserByFirstNameAndLastNameAndEmailAddress(user1.getFirstName(), user1.getLastName(), user1.getEmailAddress())).willReturn(user1);
        UserDTO userDTO = DtoMapper.toUserDto(user1);

        Assertions.assertThatThrownBy(() -> userService.createNewUser(userDTO)).isInstanceOf(Exception.class);

    }




}
