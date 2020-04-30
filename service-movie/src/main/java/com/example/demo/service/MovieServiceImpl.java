package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.MovieDAO;
import com.example.demo.entity.Movie;
import com.example.demo.exception.UserNotFoundException;

@Service
public class MovieServiceImpl implements MovieService {

	public MovieDAO movieDAO;
	
	@Autowired
	public MovieServiceImpl(MovieDAO movieDAO) {
		super();
		this.movieDAO = movieDAO;
	}

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Movie> getAllMovies(int id) {
		int obj = restTemplate.getForObject("http://localhost:1000/users/"+id, Integer.class);
		if(obj==1)
		{
			return (List<Movie>) movieDAO.findAll();
		}
		return null;
	}

	@Override
	public Movie createMovie(Movie movie, int id) {
		int obj = restTemplate.getForObject("http://localhost:1000/users/"+id, Integer.class);
		if(obj==1)
		{
			movieDAO.save(movie);
		}
		else
		{
			return null;
		}
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie, int id) {
		int obj = restTemplate.getForObject("http://localhost:1000/users/"+id, Integer.class);
		if(obj==1)
		{
			movieDAO.save(movie);
		}
		else
		{
			return null;
		}
		return movie;
	}

	@Override
	public void deleteMovieById(int movieId, int userId) throws UserNotFoundException {
		int obj = restTemplate.getForObject("http://localhost:1000/users/"+userId, Integer.class);
		if(obj==1)
		{
			Movie movie=movieDAO.findById(movieId).get();
			if(movie!=null)
			{
				movieDAO.delete(movie);
			}
			else
			{
				throw new UserNotFoundException("User not Authorized to Delete");
			}
		}
		 
		
	}

	



}
