package com.cg.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.bean.Movies;
import com.cg.movie.service.IMovieService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MovieController {

	@Autowired IMovieService service;
	
	@RequestMapping(value="/searchMovie/{genre}")
	public List<Movies> findAllByGenre(@PathVariable String genre) {
		return service.findAllByGenre(genre);
	}
	
	@RequestMapping(value="/addMovie",method=RequestMethod.POST,consumes="application/json")
	public void save(@RequestBody Movies m) {
		service.save(m);
	}
}
