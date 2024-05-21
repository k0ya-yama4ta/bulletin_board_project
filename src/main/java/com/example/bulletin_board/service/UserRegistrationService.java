package com.example.bulletin_board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bulletin_board.entity.User;
import com.example.bulletin_board.repository.UserRepository;

@Service
public class UserRegistrationService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public void userRegistration(String userid, String username, String password) {
		String hashedPassword = passwordEncoder.encode(password);
		userRepository.saveAndFlush(new User(userid, username, hashedPassword, "GENERAL"));
	}
	
	public void adminRegistration(String userid, String username, String password) {
		String hashedPassword = passwordEncoder.encode(password);
		userRepository.saveAndFlush(new User(userid, username, hashedPassword, "ADMIN"));
	}

}
