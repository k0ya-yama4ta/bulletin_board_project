package com.example.bulletin_board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bulletin_board.entity.User;
import com.example.bulletin_board.repository.UserRepository;
import com.example.bulletin_board.userDetails.UserDetailsImpl;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		User user = userRepository.findByUserid(userid);
		if(user == null) {
			throw new UsernameNotFoundException("Not Found");
		}
		httpSession.setAttribute("user",user);
		return new UserDetailsImpl(user);
	}

}
