package com.example.userservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.userservice.service.UserService;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService();
        userService.userRepository = userRepository;
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User(1L, "John", "johndoe@example.com");
        User user2 = new User(2L, "Jane", "janesmith@example.com");
        List<User> users = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(users);
        List<User> result = userService.getAllUsers();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }
}
