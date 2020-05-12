package com.cognizant.truyumm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
	
	
	@Id
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="name")
	private String name;
	@Column(name="price")
	private float price;
	@Column(name="active")
	private String active;
	@Column(name="dateoflaunch")
	private String dateoflaunch;
	@Column(name="category")
	private String category;
	@Column(name="freedelivery")
	private String freedelivery;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getDateoflaunch() {
		return dateoflaunch;
	}
	public void setDateoflaunch(String dateoflaunch) {
		this.dateoflaunch = dateoflaunch;
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
