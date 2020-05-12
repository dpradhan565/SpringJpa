package com.cognizant.truyumm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	
	
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="freedelivery")
	private String freedelivery;
	@Column(name="price")
	private float price;	
	@Column(name="category")
	private String category;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFreedelivery() {
		return freedelivery;
	}
	public void setFreedelivery(String freedelivery) {
		this.freedelivery = freedelivery;
	}
	

}

