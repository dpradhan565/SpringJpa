package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	@Query("from Country where name LIKE %:match%")
	List<Country> findByNameMatch(Sort sort ,@Param("match")String s);

	@Query("from Country where name LIKE :alphabet%")
	List<Country> findStartsWith(@Param("alphabet")String s);
}
