package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.UserResponseEntity;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {
	
	public MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@GetMapping("/movies/{id}")
	public List<Movie> getAllMovies(@PathVariable int id) throws UserNotFoundException
	{
		List<Movie> list = movieService.getAllMovies(id);
		if(list==null)
			throw new UserNotFoundException("User Is Not Authorized");
		return list;
	}
	
	@ExceptionHandler
	public ResponseEntity<UserResponseEntity> handleException(UserNotFoundException snfe)
	{
		return new ResponseEntity<UserResponseEntity>(new UserResponseEntity(HttpStatus.NOT_FOUND.value(), snfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/movies/{userId}")
	public void createMovie(@RequestBody Movie movie,@PathVariable("userId") int userId) throws UserNotFoundException
	{
		Movie objMovie=movieService.createMovie(movie, userId);
		if(movie==null)
			throw new UserNotFoundException("user Is Not Authorized");
	}
	
	@PutMapping("/movies/{userId}")
	public void updateMovie(@RequestBody Movie movie,@PathVariable("userId") int userId) throws UserNotFoundException
	{
		Movie objMovie=movieService.updateMovie(movie, userId);
		if(movie==null)
			throw new UserNotFoundException("user Is Not Authorized");
	}
	
	
	@DeleteMapping("/movies/{movieId}/{userId}")
	public void deleteMovie(@PathVariable("movieId")int movieId, @PathVariable("userId")int userId)
	{
		try {
			movieService.deleteMovieById(movieId, userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
