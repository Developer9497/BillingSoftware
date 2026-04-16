package com.billingsoftware.app.dropdown.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class PackingEntity  {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String packing;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public PackingEntity(Long id, String packing) {
		super();
		this.id = id;
		this.packing = packing;
	}
	public PackingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
