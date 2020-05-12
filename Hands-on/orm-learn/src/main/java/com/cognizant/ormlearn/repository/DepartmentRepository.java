package com.cognizant.ormlearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
