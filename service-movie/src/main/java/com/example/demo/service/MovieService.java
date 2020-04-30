package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Movie;
import com.example.demo.exception.UserNotFoundException;

public interface MovieService {

	public List<Movie> getAllMovies(int id);
	public Movie createMovie(Movie movie,int id);
	public Movie updateMovie(Movie movie,int id);
	public void deleteMovieById(int movieId, int userId) throws UserNotFoundException;
}
