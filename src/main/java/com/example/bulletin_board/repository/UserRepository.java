package com.example.bulletin_board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bulletin_board.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserid(String userid);
	
	Page<User> findAll(Pageable pageable);
}
