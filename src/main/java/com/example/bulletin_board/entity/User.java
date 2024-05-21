package com.example.bulletin_board.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
public class User {

	/*
	 * property
	 */
	@Id
	@Column(name="id")
	private String userid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="created_date", updatable=false)
	@CreatedDate
	private Date createdAt;
	
	@Column(name="rolename")
	private String rolename;
	
	public User (String _userid, String _username, String _password, String _rolename) {
		this.userid = _userid;
		this.username = _username;
		this.password = _password;
		this.rolename = _rolename;
	}
	
}
