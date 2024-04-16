package com.vote.Voter.sApp.pvc.servicesImpl;

import com.vote.Voter.sApp.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@RequiredArgsConstructor
@SpringBootTest
class PvcServiceImplTest {

    private final UserService userService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void registerPvc() {
//       assertDoesNotThrow(()->{
//           userService.createUser()
//       });
    }
}