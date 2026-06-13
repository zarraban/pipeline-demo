package org.example.project.service;

import org.example.project.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;

    private static final String BASIC_USERNAME = "Dummy_User";
    private static final String BASIC_EMAIL = "dummy@gmail.com";


    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testCreateUser_Success() {
        User user = userService.createUser(BASIC_USERNAME, BASIC_EMAIL);

        assertNotNull(user);
        assertEquals(BASIC_USERNAME, user.getUsername());
        assertEquals(BASIC_EMAIL, user.getEmail());
    }

    @Test
    void testCreateUser_ThrowsExceptionOnEmptyUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser("   ", BASIC_EMAIL);
        });
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testCreateUser_ThrowsExceptionOnInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(BASIC_USERNAME, "invalid-email-string");
        }, "Should throw exception due to missing '@' or '.'");
    }

    @Test
    void testCreateUser_ThrowsExceptionOnSpacesInUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser("vlad smyrnov", BASIC_EMAIL);
        }, "Username must not contain spaces");
    }
}