package com.example.bulletin_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bulletin_board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
