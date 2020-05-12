package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

	@Query("SELECT s FROM  Stock s WHERE s.code=:code and s.stockDate >= '2019-09-01' and s.stockDate <= '2019-09-30'")
	List<Stock> getAllFbSept(@Param("code") String code);

	@Query("select s from Stock s where s.code=:code and s.stockOpen>1250")
	List<Stock> getAllGoogle(@Param("code") String code);

	@Query("select s from Stock s ")
	List<Stock> getAllTopThree(Pageable p);

	@Query("select s from Stock s where s.code=:code ")
	List<Stock> getLeastThreeNetflix(@Param("code") String code, Pageable p);

}
