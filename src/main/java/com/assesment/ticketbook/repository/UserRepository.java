package com.assesment.ticketbook.repository;

import com.assesment.ticketbook.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmailAddress(String emailAddress);
    User getUserByFirstNameAndLastNameAndEmailAddress(String firstName, String lastName, String emailAddress);


}
