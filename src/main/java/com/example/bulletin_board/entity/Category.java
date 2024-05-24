package com.example.bulletin_board.entity;

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
@Table(name="categories")
@EntityListeners(AuditingEntityListener.class)
public class Category {
	
	/*
	 * property
	 */
	@Id
	@Column(name="categoryid")
	private int id;
	
	@Column(name="categoryname")
	private String name;
	
	public Category(int _id, String _name) {
		this.id = _id;
		this.name = _name;
	}

}
