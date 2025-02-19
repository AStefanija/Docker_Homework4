package com.example.authservice;

import static org.mockito.Mockito.*;

import com.example.authservice.service.AuthService;
import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceApplicationTests {

	private AuthService authService;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		authService = new AuthService(userRepository);
	}

	@Test
	void testAuthenticateUser() {
		User user = new User(3L, "Doe", "password123", "admin");
		userRepository.findByUsername("Doe");
		authService.authenticate("Doe", "password123");
	}
}
