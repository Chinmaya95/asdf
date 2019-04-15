package com.cg.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.bean.Movies;
import com.cg.movie.dao.IMovieDAO;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired IMovieDAO dao;
	
	@Override
	public List<Movies> findAllByGenre(String genre) {
		// TODO Auto-generated method stub
		return dao.findByMoviesGenre(genre);
	}

	@Override
	public void save(Movies m) {
		// TODO Auto-generated method stub
		dao.save(m);
	}

}
