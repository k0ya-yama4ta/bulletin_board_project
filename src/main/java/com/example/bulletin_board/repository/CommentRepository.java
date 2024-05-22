package com.example.bulletin_board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bulletin_board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByUserid(String userid);
	
	Page<Comment> findAllByOrderByIdDesc(Pageable pageable);
}
