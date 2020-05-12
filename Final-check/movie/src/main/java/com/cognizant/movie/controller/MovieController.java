package com.cognizant.movie.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.movie.MovieApplication;
import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movie;
import com.cognizant.movie.service.Service;

@Controller
public class MovieController {

	@Autowired
	Service service;
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieApplication.class);

	@RequestMapping("/movie-list-admin")
	public String showMovies(ModelMap model) throws ParseException {
		LOGGER.info("Start");

		/*
		 * Movie m=new Movie(); m.setId(5L); m.setActive("No");
		 * m.setBoxOffice("$1,671,713,208"); m.setGenre("Science Fiction");
		 * m.setHasTeaser("Yes"); m.setTitle("Jurassic World"); Date date1=new
		 * SimpleDateFormat("dd/MM/yyyy").parse("02/07/2017"); m.setDateOfLaunch(date1);
		 * movierepo.save(m);
		 */
		List<Movie> list = service.getMovieListAdmin();
		LOGGER.debug("movieList={}", list);
		model.addAttribute("movielist", list);
		LOGGER.info("End");
		return "movie-list-admin";
	}

	@RequestMapping("/edit-movie")
	public String EditMenuItemListAdmin(ModelMap model, @RequestParam Long id) {
		LOGGER.info("Start");
		Movie movie = service.findMovieByID(id);
		LOGGER.debug("movie={}", movie);
		model.addAttribute("movie", movie);
		LOGGER.info("End");
		return "edit-movie";

	}

	@RequestMapping("edit-movie-status")
	public String updaeStatus(ModelMap map, @RequestParam Long id, @RequestParam String title,
			@RequestParam String boxOffice, @RequestParam String active, @RequestParam String dateOfLaunch,
			@RequestParam String genre, @RequestParam(defaultValue = "false") String hasTeaser) throws ParseException {
		LOGGER.info("Start");

		Movie m = new Movie();
		m.setId(id);
		m.setTitle(title);
		boxOffice = "$ " + boxOffice;
		m.setBoxOffice(boxOffice);
		m.setActive(active);
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfLaunch);
		m.setDateOfLaunch(date1);
		m.setGenre(genre);
		if (hasTeaser.equals("on"))
			hasTeaser = "Yes";
		else
			hasTeaser = "No";
		m.setHasTeaser(hasTeaser);
		service.saveMovie(m);
		List<Movie> mov = service.getMovieListAdmin();
		LOGGER.debug("movieListAdmin={}", mov);
		map.put("menulist", mov);
		LOGGER.info("End");
		return "edit-movie-status";
	}

	@RequestMapping("/movie-list-customer")
	public String favoriteList(ModelMap map) {
		LOGGER.info("Start");
		List<Movie> customer = service.getMovieListCustomer("Yes");
		LOGGER.debug("movieListCustomer={}", customer);
		map.put("customerlist", customer);
		LOGGER.info("End");
		return "movie-list-customer";
	}

	@RequestMapping("/movie-list-customer-notification")
	public String FavoriteNotification(ModelMap map, @RequestParam Long id) {
		LOGGER.info("Start");

		service.saveFavMovie(id);
		List<Movie> customer = service.getMovieListCustomer("Yes");
		LOGGER.debug("MovieList={}", customer);

		map.put("customerlist", customer);
		LOGGER.info("End");
		return "movie-list-customer-notification";
	}

	@RequestMapping("/favorites")
	public String Favorite(ModelMap model) {
		LOGGER.info("Start");
		List<Favorites> favList = service.getFavMovie();
		LOGGER.debug("favFovieList={}", favList);
		if (favList.size() < 0) {
			return "favorites-empty";
		}
		model.addAttribute("favorites", favList);
		LOGGER.info("End");
		return "favorites";
	}

	@RequestMapping("/favorites-notification")
	public String FavoriteNoti(ModelMap map, @RequestParam Long id) {
		LOGGER.info("Start");
		service.deleteFav(id);
		LOGGER.info("End");
		return "redirect:/favorites";
	}

}
