package com.example.bulletin_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bulletin_board.entity.Comment;
import com.example.bulletin_board.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> getAllComment(){
		return commentRepository.findAll();
	}
	
	public void addComment(String _userid, String _content) {
		commentRepository.saveAndFlush(new Comment(_userid, _content));
	}
	
	public void deleteComment(int _id) {
		commentRepository.deleteById(_id);
	}

}
