package com.cognizant.ormlearn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {
	@Id
	@Column(name="st_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="st_code")
	private String code;
	@Column(name="st_date")
	private Date stockDate;
	@Column(columnDefinition="numeric(10,2)",name="st_open")
	private long stockOpen;
	@Column(columnDefinition="numeric(10,2)",name="st_close")
	private long stockClose;
	@Column(name="st_volume")
	private int volume;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getStockDate() {
		return stockDate;
	}
	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}
	public long getStockOpen() {
		return stockOpen;
	}
	public void setStockOpen(long stockOpen) {
		this.stockOpen = stockOpen;
	}
	public long getStockClose() {
		return stockClose;
	}
	public void setStockClose(long stockClose) {
		this.stockClose = stockClose;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", stockDate=" + stockDate + ", stockOpen=" + stockOpen
				+ ", stockClose=" + stockClose + ", volume=" + volume + "]";
	}
	
	
	
}
