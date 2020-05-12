package com.cognizant.truyumm.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.truyumm.model.Menu;

public interface UserRepository extends CrudRepository<Menu,Long>  {

}
