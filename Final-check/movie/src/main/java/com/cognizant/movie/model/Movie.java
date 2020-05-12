package com.cognizant.movie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@Column(name="id")
	private long id;
	@Column(name="title")
	private String title;
	@Column(name="boxoffice")
	private String boxOffice;
	@Column(name="active")
	private String active;
	@Column(name="dateoflaunch")
	private Date dateOfLaunch;
	@Column(name="genre")
	private String genre;
	@Column(name="hasteaser")
	private String hasTeaser;

	
	

	public Movie() {
		super();
	}

	public Movie(long id, String title, String boxOffice, String active, Date dateOfLaunch, String genre,
			String hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	public String isActive() {
		return active;
	}
	public String getActive() {
		return active;
	}

	
	public void setActive(String active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String isHasTeaser() {
		return hasTeaser;
	}
	public String getHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(String hasTeaser) {
		this.hasTeaser = hasTeaser;
	}



}
