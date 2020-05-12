package com.cognizant.ormlearn.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	@Autowired
	StockRepository stockRepository;

	@Transactional
	public void getAllFbSeptService() {
		List<Stock> allFbSept = stockRepository.getAllFbSept("FB");
		for (Stock s : allFbSept) {
			System.out.println(s.toString());
		}
	}

	@Transactional
	public void getAllGoogleService() {
		List<Stock> list = stockRepository.getAllGoogle("GOOGL");
		for (Stock s : list) {
			System.out.println(s.toString());
		}
	}

	@Transactional
	public void getTopThreeService() {
		Pageable sortedByVolume = PageRequest.of(0, 3, Sort.by("volume").descending());
		List<Stock> list = stockRepository.getAllTopThree(sortedByVolume);
		for (Stock s : list) {
			System.out.println(s.toString());
		}
	}

	@Transactional
	public void getLeastNetflixService() {
		Pageable sortedByStockOpen = PageRequest.of(0, 3, Sort.by("stockOpen").ascending());
		List<Stock> list = stockRepository.getLeastThreeNetflix("NFLX", sortedByStockOpen);
		for (Stock s : list) {
			System.out.println(s.toString());
		}

	}

	@Transactional
	public void criteriaQuery() {
		LOGGER.info("Start");
		try (Session session = com.cognizant.ormlearn.utility.HibernateUtility.getSessionFactory().openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Stock> cr = cb.createQuery(Stock.class);
			Root<Stock> root = cr.from(Stock.class);
			cr.select(root);

			Query<Stock> query = session.createQuery(cr);
			List<Stock> results = query.getResultList();
			LOGGER.debug("stock={}", results);
			LOGGER.info("End");

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
