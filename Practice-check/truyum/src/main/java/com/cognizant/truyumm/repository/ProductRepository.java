package com.cognizant.truyumm.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.truyumm.model.Cart;

public interface ProductRepository extends CrudRepository<Cart,Integer>{

}
