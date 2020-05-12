package com.cognizant.movie.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

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

	@Transactional
	public List<Movie> getMovieListAdmin() throws ParseException {
		
		return (List<Movie>) movierepo.findAll();
		
				}

	@Transactional
	public Movie findMovieByID(Long id) {
		Optional<Movie> movieOptional = movierepo.findById(id);
		if (movieOptional.isPresent()) {
			return movieOptional.get();
		}
		return null;
	}

	@Transactional
	public void saveMovie(Movie m) {
		movierepo.save(m);
	}

	@Transactional
	public List<Movie> getMovieListCustomer(String s) {
		return movierepo.getMovieListActive(s);
	}

	@Transactional
	public void saveFavMovie(Long id) {
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

	}

	@Transactional
	public List<Favorites> getFavMovie() {
		return (List<Favorites>) favrepo.findAll();
	}

	@Transactional
	public void deleteFav(Long id) {
		favrepo.deleteById(id);
	}
}
