package com.ecommerce.ecart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apparal")
public class Apparal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="apparal_id")
	private long apparalId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="design")
	private String design;

	public long getApparalId() {
		return apparalId;
	}

	public void setApparalId(long apparalId) {
		this.apparalId = apparalId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}
	
	
	

}
