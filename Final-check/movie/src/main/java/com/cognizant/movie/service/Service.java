package com.cognizant.movie.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.movie.MovieApplication;
import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movie;
import com.cognizant.movie.repository.FavoriteRepository;
import com.cognizant.movie.repository.MovieRepository;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	MovieRepository movierepo;
	@Autowired
	FavoriteRepository favrepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieApplication.class);

	@Transactional
	public List<Movie> getMovieListAdmin() throws ParseException {

		return (List<Movie>) movierepo.findAll();

	}

	@Transactional
	public Movie findMovieByID(Long id) {
		LOGGER.info("Start");
		Optional<Movie> movieOptional = movierepo.findById(id);
		
		if (movieOptional.isPresent()) {
			return movieOptional.get();
		}
		LOGGER.info("End");
		return null;
		
	}

	@Transactional
	public void saveMovie(Movie m) {
		LOGGER.info("Start");
		movierepo.save(m);
		LOGGER.info("End");
	}

	@Transactional
	public List<Movie> getMovieListCustomer(String s) {
		return movierepo.getMovieListActive(s);
	}

	@Transactional
	public void saveFavMovie(Long id) {
		LOGGER.info("Start");
		Favorites f = new Favorites();
		Optional<Movie> movieOptional = movierepo.findById(id);
		if (movieOptional.isPresent()) {
			Movie m = movieOptional.get();
			f.setId(m.getId());
			f.setTitle(m.getTitle());
			f.setGenre(m.getGenre());
			f.setBoxOffice(m.getBoxOffice());
		}
		favrepo.save(f);
		LOGGER.info("End");
	}

	@Transactional
	public List<Favorites> getFavMovie() {
		
		return (List<Favorites>) favrepo.findAll();
	}

	@Transactional
	public void deleteFav(Long id) {
		LOGGER.info("Start");
		favrepo.deleteById(id);
		LOGGER.info("End");
	}
}
