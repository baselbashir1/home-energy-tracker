package com.basel.user_service;

import com.basel.user_service.entity.User;
import com.basel.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserServiceApplicationTests {

    private static final int NUMBER_OF_USERS = 10;

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;

    @Disabled
    @Test
    void addUsersToDB() {
        for (int i = 1; i <= NUMBER_OF_USERS; i++) {
            User user = new User();
            user.setName("User" + i);
            user.setSurname("Surname" + i);
            user.setEmail("user" + i + "@example.com");
            user.setAddress(i + " Example St");
            user.setAlerting(i % 2 == 0);
            user.setEnergyAlertingThreshold(1000.0 + i);
            userRepository.save(user);
        }
        log.info("User Repository populated successfully");
    }
}