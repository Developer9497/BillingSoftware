package com.billingsoftware.app.dropdown.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class UnitTypeEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String unitType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public UnitTypeEntity(Long id, String unitType) {
		super();
		this.id = id;
		this.unitType = unitType;
	}

	public UnitTypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
