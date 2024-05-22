package com.example.bulletin_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bulletin_board.entity.User;
import com.example.bulletin_board.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public Page<User> getPageUser(Pageable _pageable){
		return userRepository.findAll(_pageable);
	}
	
	public User getUser(String _userid) {
		return userRepository.findByUserid(_userid);
	}
	

}
