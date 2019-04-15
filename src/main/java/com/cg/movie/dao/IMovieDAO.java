package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.bean.Movies;
import java.lang.String;

@Repository
public interface IMovieDAO extends JpaRepository<Movies, Integer>{
	
		 List<Movies> findByMoviesGenre(String moviesgenre);
}
