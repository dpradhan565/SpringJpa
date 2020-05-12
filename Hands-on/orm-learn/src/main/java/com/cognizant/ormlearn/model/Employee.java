package com.cognizant.ormlearn.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="em_id")
	private int id;
	@Column(name="em_name")
	private String name;
	@Column(name="em_salary")
	private double salary;
	@Column(name="em_permanent")
	private boolean permanent;
	@Column(name="em_date_of_birth")
	private Date dateOFBirth;
	@ManyToOne
	@JoinColumn(name = "em_dp_id")
	private Department department;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="employee_skill",
	joinColumns=@JoinColumn(name="es_em_id",referencedColumnName="em_id"),
	inverseJoinColumns = @JoinColumn(name="es_sk_id",referencedColumnName="sk_id"))
	private Set<Skill> skillSet;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Date getDateOFBirth() {
		return dateOFBirth;
	}
	public void setDateOFBirth(Date dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Skill> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}
	
	

}
