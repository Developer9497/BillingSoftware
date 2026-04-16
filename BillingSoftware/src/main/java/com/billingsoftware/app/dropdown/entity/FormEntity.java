package com.billingsoftware.app.dropdown.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FormEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String form;
	public FormEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormEntity(Long id, String form) {
		super();
		this.id = id;
		this.form = form;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}

}
