package com.cognizant.ormlearn;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static CountryService countryService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static StockService stockService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(OrmLearnApplication.class, args);
		//countryService = context.getBean(CountryService.class);
		employeeService=context.getBean(EmployeeService.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		stockService=context.getBean(StockService.class);
		
		//testGetAllCountries();
		//Country nc=new Country();
		//nc.setCode("AF");
		//nc.setName("Afghanistan");
		
		//testDeleteCountry("AF");
		//testFindCountry("IN");
		//testUpdateCountry("US");
		//testGetAllCountries();
		//testFindCountryByMatch("ni");
		//testFindStarts("a");
		
		//mapping Eager Fetch is applied For ManyToOne and OneToOne relationships.
		//Hence department details as well is joined and
		
		//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
		//testGetDepartment();
		//testAddSkillToEmployee();
		//testGetAverageSalaryByDepartment(2);
		//testGetAllEmployees();
		//testGehttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1617241tAllFbSept();
		//testGetAllGoogleStock();
		//testGetAllTopThreeStockhttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1617241();
		//testGetLeastThreeNetflix();
		testCriteriaQuery();
		LOGGER.info("Inside main");
	}
	//	
	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
		}
	
	private static void testInsertCountry(Country country) {
		LOGGER.info("Start");
		Country c = countryService.insertCountry(country);
		LOGGER.debug("countries={}",c);
		LOGGER.info("End");
		}

	private static void testFindCountry(String id) {
		LOGGER.info("Start");
		Country c = countryService.getCountry(id);
		LOGGER.debug("countries={}",c);
		LOGGER.info("End");
		}
	
	private static void testUpdateCountry(String id) {
		LOGGER.info("Start");
		Country country=countryService.getCountry(id);
		country.setName("USA");
		Country c = countryService.updateCountry(country);
		LOGGER.debug("countries={}",c);
		LOGGER.info("End");
		}
	
	private static void testDeleteCountry(String id) {
		LOGGER.info("Start");
		 countryService.deleteCountry(id);
		LOGGER.info("End");
		}

	private static void testFindCountryByMatch(String s) {
		LOGGER.info("Start");
		 List<Country> c=countryService.findByM(s);
		 LOGGER.debug("countries={}", c);
		LOGGER.info("End");
		}
	
	private static void testFindStarts(String s) {
		LOGGER.info("Start");
		 List<Country> c=countryService.findByM(s);
		 LOGGER.debug("countries={}", c);
		LOGGER.info("End");
		}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		//Include fetch type as eager in @ManyToMany annotation of Employee.java,
		//which will fetch the skill details as well
		LOGGER.debug("Skills:{}", employee.getSkillSet());
		LOGGER.info("End");
		}
	
	private static void testAddEmployee() {
		LOGGER.info("Start");
		Employee emp=new Employee();
		emp.setName("Shaktimaan");
		emp.setPermanent(true);
		emp.setSalary(40000d);
		emp.setDateOFBirth(new Date());
		Department dpt=departmentService.get(1);
		emp.setDepartment(dpt);
		employeeService.save(emp);
		LOGGER.debug("Employee:{}", emp);
		LOGGER.info("End");
	}
	
	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee=employeeService.get(1);
		Department dept=departmentService.get(2);
		employee.setDepartment(dept);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}
	
	private static void testGetDepartment() {
		LOGGER.info("Start");
		//get a department using departmentService.get() passing the id. 
		//Select an department id that has more than one employee
		Department department=departmentService.get(1);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Employee:{}", department.getEmployeeList());
		/*
		 e the default fetch type for OneToMany relationship is LAZY, hibernate fetches only department details and does not get the employee details.
· In order to get the employee list as well, modify the annotation to include the fetch type as EAGER. Make this change in employeeList annotation definition of Department class.
@OneToMany(mappedBy = "department", fetch=FetchType.EAGER)
*/
		LOGGER.info("End");
	}
	
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		//Identify an employee id and skill id
		//for which a relationship does not exists
		Employee employee=employeeService.get(2);
		Skill skill=skillService.get(3);
		employee.getSkillSet().add(skill);
		employeeService.save(employee);
		
		LOGGER.info("End");
	}
	
	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getEmployeePermanent();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillSet()));
		LOGGER.info("End");

		}
	public static void testGetAverageSalaryByDepartment(int id) {
		LOGGER.info("Start");
		Double avg=employeeService.getSalaryAverageByDepartment(id);
		LOGGER.debug("Average Sal", avg);
		LOGGER.info("End");
	}
	public static void testGetAllEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllEmployees();
		LOGGER.debug("Employees:{}", employees);
		LOGGER.info("End");

		}
	public static void testGetAllFbSept() {
		LOGGER.info("Start");
		stockService.getAllFbSeptService();
		LOGGER.info("End");

		}
	public static void testGetAllGoogleStock() {
		LOGGER.info("Start");
		stockService.getAllGoogleService();
		LOGGER.info("End");

		}
	
	public static void testGetAllTopThreeStock() {
		LOGGER.info("Start");
		stockService.getTopThreeService();
		LOGGER.info("End");

		}
	
	public static void testGetLeastThreeNetflix() {
		LOGGER.info("Start");
		stockService.getLeastNetflixService();
		LOGGER.info("End");

		}
	
public static void testCriteriaQuery() {
	stockService.criteriaQuery();
}
}
