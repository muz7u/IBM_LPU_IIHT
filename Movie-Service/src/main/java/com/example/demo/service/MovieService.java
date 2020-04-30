package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Movie;

public interface MovieService {

	public List<Movie> getAllMovies();
	public List<Movie> getMovie(int userId);
}
