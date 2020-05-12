package com.cognizant.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.movie.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

	@Query("select  m from Movie m where m.active=:activeStatus")
	List<Movie> getMovieListActive(@Param("activeStatus") String s);

}
