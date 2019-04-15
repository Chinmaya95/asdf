package com.cg.movie.service;

import java.util.List;

import com.cg.movie.bean.Movies;

public interface IMovieService {

	public List<Movies> findAllByGenre(String genre);
	public void save(Movies m);
}
