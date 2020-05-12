package com.cognizant.ormlearn.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	 private static SessionFactory factory; 
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
		
	}
	@Transactional
	public List<Employee> getEmployeePermanent() {
		
		return employeeRepository.getAllPermanentEmployees();
		
	}
	@Transactional
	public double getSalaryAverageByDepartment(int id) {
		
		return employeeRepository.getAverageSalary(id);
		
	}
	@Transactional
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.getAllEmployeesNative();
	}
		
}
