package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {

	private MovieService service;

	@Autowired
	public MovieController(MovieService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies()
	{
		return service.getAllMovies();
	}
	
	@GetMapping("/movie/{userId}")
	public List<Movie> getMovies(@PathVariable("userId")int userId) throws UserNotFoundException
	{
		
		List<Movie> list = service.getMovie(userId);
		if(list == null)
			throw new UserNotFoundException("No User Exist with userId: "+userId);
		else
			return list;
	}
	
}
