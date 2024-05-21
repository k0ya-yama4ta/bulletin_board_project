package com.example.bulletin_board.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="comments")
@EntityListeners(AuditingEntityListener.class)
public class Comment {
	
	/*
	 * property
	 */
	@Id
	@GeneratedValue
	private int id;
	private String userid;
	private String content;
	private int likes;
	
	@Column(name="created_date", updatable=false)
	@CreatedDate
	private Date createdAt;
	
	public Comment (String _userid, String _content) {
		this.userid = _userid;
		this.content = _content;
	}


}
