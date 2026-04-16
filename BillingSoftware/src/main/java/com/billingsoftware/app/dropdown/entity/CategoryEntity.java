package com.billingsoftware.app.dropdown.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Category;
	public CategoryEntity(Long id, String category) {
		super();
		this.id = id;
		Category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
